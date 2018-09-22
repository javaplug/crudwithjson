package com.jsoneg.demo.helper;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.jsoneg.demo.dto.SampleDTO;

@Component
public final class JsonHelper {

	private final ObjectMapper objectMapper;

	public JsonHelper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public void insertNode(ObjectNode updatenode, String target, Map<String, String> input) {
		ObjectNode newNode = objectMapper.createObjectNode();
		input.entrySet().stream().forEach(entry -> newNode.put(entry.getKey(), entry.getValue()));
		updatenode.set(target, newNode);
	}

	public void updateValue(ObjectNode updatenode, String target, String input) {
		TextNode newValue = new TextNode(input);
		updatenode.set(target, newValue);
	}
	
	public void deleteNode(ObjectNode updatenode, String target) {
		Optional.ofNullable(updatenode.get(target))
		.ifPresent(team -> {
			System.out.println("Removing : " + updatenode.get(target));
			updatenode.remove(target);
			});
	}

	public SampleDTO getDTO(ObjectNode updatenode) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(updatenode.toString(), SampleDTO.class);
	}
	
	
}
