package br.com.restlabs;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GrettingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/gretting")
	public Gretting gretting(
			@RequestParam(value="name",defaultValue="Word")String name) {
		return new Gretting(counter.incrementAndGet(), String.format(template, name));
	}
	

}
