package com.sabre.hospitality.controller.v1.example;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sabre.radius.client.ice.IceSession;
import com.sabre.radius.client.ice.IceSessionPool;
import com.sabre.radius.client.ice.IceSessionPoolImpl;
import com.sabre.saap.commons.controller.AbstractController;
import com.sabre.saap.commons.dao.MultiBucketKeyValueDao;
import com.sabre.saap.commons.log.LogMetrics;

/**
 * 
 * @author Vishal Bhasin
 */
@RequestMapping("/v1/example")
@Controller
public class RadiusSessionPoolExampleController extends AbstractController {
	
	@Autowired
	private IceSessionPool pool;

	void setIceSessionPool(IceSessionPool pool) {
		this.pool = pool;
	}
	

	@RequestMapping(value = "/{input}", method = RequestMethod.GET, produces = "application/json")
	@LogMetrics
	public @ResponseBody
	ResponseEntity<JsonNode> getInput(
			@PathVariable("input") String input) {
		
		IceSession session1 = pool.borrowSession();
        String ath = session1.getAthId();
        pool.returnSession( session1 );
                
        ObjectNode response = objectMapper.createObjectNode();
		response.put("input", input);        
		return new ResponseEntity<JsonNode>(response, HttpStatus.OK);
	}
}
