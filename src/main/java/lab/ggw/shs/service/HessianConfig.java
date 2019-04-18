package lab.ggw.shs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

@Configuration
public class HessianConfig {

	@Autowired
	private ISimpleService service;
	
	@Bean(name = "/simple")
	public HessianServiceExporter hessianServiceExporter() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		
		exporter.setService(service);
		exporter.setServiceInterface(ISimpleService.class);
		
		return exporter;
	}
	
}
