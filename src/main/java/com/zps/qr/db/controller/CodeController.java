package com.zps.qr.db.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.zps.qr.db.model.Code;
import com.zps.qr.db.repository.CodeRepository;
import com.zps.qr.db.exception.ResourceNotFoundException;
import com.zps.qr.db.model.AuthRequest;
import com.zps.qr.db.util.JwtUtil;


@RestController
//@RequestMapping("/api/v1")
public class CodeController {
	
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private CodeRepository codeRepository;
	
	//get codes
	@GetMapping("/codes")
	public List<Code> getAllCodes(){
		
		return this.codeRepository.findAll();	
	}
	
	//get code by id / not nessesary
	@GetMapping("/codes/{id}")
	public ResponseEntity<Code> getCodeById(@PathVariable(value = "id") Long codeId)
	 throws ResourceNotFoundException {
		Code code  = codeRepository.findById(codeId)
		  .orElseThrow(() -> new ResourceNotFoundException(" Code not found for this id :: "+ codeId));
		  return ResponseEntity.ok().body(code);
	}
	// save code
	@PostMapping("/codes")
	public Code createCode(@Valid @RequestBody Code code) {
		return this.codeRepository.save(code);
		
	}
	
	// update code
	@PutMapping("/codes/{id}")
	public ResponseEntity<Code> updateCode(@PathVariable(value = "id")Long codeId,
		@Valid @RequestBody Code codeDetails) throws ResourceNotFoundException{
		
		Code code  = codeRepository.findById(codeId)
				  .orElseThrow(() -> new ResourceNotFoundException(" Code not found for this id :: "+ codeId));
		
		//code.setId(codeDetails.getId());
		//code.setUserId(codeDetails.getUserId());
		code.setmCodeImagePath(codeDetails.getmCodeImagePath());
		code.setmContent(codeDetails.getmContent());
		code.setmDescribe(codeDetails.getmDescribe());
		code.setmCodeImg(codeDetails.getmCodeImg());
		code.setmTimeStamp(codeDetails.getmTimeStamp());
		code.setmType(codeDetails.getmType());
		code.setmDName(codeDetails.getmDName());
		code.setmDSerial(codeDetails.getmDSerial());
		
		return ResponseEntity.ok(this.codeRepository.save(code));
		
	}
	// delete code
	@DeleteMapping("/codes/{id}")
	public Map<String, Boolean>deleteCode(@PathVariable(value = "id")Long codeId) throws ResourceNotFoundException{
		
		Code code  = codeRepository.findById(codeId)
				  .orElseThrow(() -> new ResourceNotFoundException(" Code not found for this id :: "+ codeId));
		
		this.codeRepository.delete(code);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(), authrequest.getPassword()));
		}
		catch (Exception e) {
			throw new Exception("Invalid username and password");
		}
		
		return jwtUtil.generateToken(authrequest.getUserName());
	}
	

}
