package org.si.samples.transformer;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.Transformer;
import org.springframework.stereotype.Component;

import spring.integration.rest.sample.jaxb.model.ObjectModel;

@Component("customToStringObject")
public class CustomToStringObject implements Transformer {

	@Override
	public Message<String> transform(Message<?> message) {
		ObjectModel model = (ObjectModel) message.getPayload();
		String payload = ReflectionToStringBuilder.toString(model);
		Message<String> msg = MessageBuilder.withPayload(payload).copyHeaders(message.getHeaders()).build();
		return msg;
	}

}
