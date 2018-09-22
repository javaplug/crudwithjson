package com.jsoneg.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.jsoneg.demo.dto.SampleDTO;
import com.jsoneg.demo.helper.JsonHelper;

@RestController
public class JsonController {

	private final JsonHelper jsonHelper;

	public JsonController(JsonHelper jsonHelper) {
		this.jsonHelper = jsonHelper;
	}

	@PostMapping("/json")
	public ResponseEntity<?> sampleJSON(@RequestBody JsonNode rootnode)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Input : " + rootnode);
		ObjectNode updatenode = (ObjectNode) rootnode;

		// Warm up
		String target = "target";

		// Insert values
		Map<String, String> input = new HashMap<>();
		input.put("key1", "create");
		input.put("key2", "create");

		jsonHelper.insertNode(updatenode, target, input);
		System.out.println("Created : " + rootnode);

		// Updating the same
		jsonHelper.updateValue(updatenode, target, "update");
		System.out.println("Updated : " + rootnode);

		// Search and Delete
		jsonHelper.deleteNode(updatenode, "teamName");

		System.out.println("Result : " + rootnode);
		System.out.println(jsonHelper.getDTO(updatenode));
		return null;
	}

}
