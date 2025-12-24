package org.example.tliaswebmanagement;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

	@Autowired
	private EmpMapper empMapper;
	@Test
	public void genJwt(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 10);
		claims.put("username", "itheima");

		String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
				.addClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000)) //有效期60s
				.compact();
		System.out.println(jwt);
		//输出结果：eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjczMDA5NzU0fQ.RcVIR65AkGiax-ID6FjW60eLFH3tPTKdoK7UtE4A1ro
	}

	@Test
	public void parseJwt(){
		Claims claims = Jwts.parser()
				.setSigningKey("aXRjYXN0")//指定签名密钥
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjczMDA5NzU0fQ.RcVIR65AkGiax-ID6FjW60eLFH3tPTKdoK7UtE4A1ro")
				.getBody();

		System.out.println(claims);
	}



}
