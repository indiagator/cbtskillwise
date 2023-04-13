package com.cbt.cbtskillwise;

import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/1.1")
public class MainRestController
{
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    UserdetailRepository userdetailRepository;
    @Autowired
    UsernameUsertypeLinkRepository usertypeLinkRepository;

    @Autowired
    UserdetailService userdetailService;


    @GetMapping("login")
    public ResponseEntity<String> generateToken(@RequestBody Credential credential )
    {
        StringBuilder token = new StringBuilder();
        token.append(credential.getUsername());
        token.append(credential.getPassword());

        return new ResponseEntity<String>(String.valueOf(token),HttpStatus.OK);

    }

    @GetMapping("auth")
    public ResponseEntity<String> auth(@RequestHeader("Authorization") String bearerToken)
    {
        //Map<String,List<String>> headersMap =  headers.map();

       // String resValue = "";

        //for(Map.Entry<String,List<String>> entry: headersMap.entrySet()  )
       // {
         //   if(entry.getKey().equalsIgnoreCase("Authorization"))
         //  {
          //      List<String> authValues = entry.getValue();

          //      resValue= authValues.get(0); // We need to check whether this is a Authentic Bearer Token
          //  }
        //}

       // Map<String,String> resBody = new HashMap<>();
       // resBody.put("message",resValue);
        return new ResponseEntity<String>(bearerToken,HttpStatus.OK);


    }

    @PostMapping("signup")
    public ResponseMessage signup(@RequestBody Credential credential) // 'C' rest endpoint for ENTITY: CREDENTIAL
    {
        credentialRepository.save(credential);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("New Signup Successful!");
        return responseMessage;
    }

    @PostMapping("save/userdetails")
    public Userdetail saveUserDetails(@RequestBody Userdetail userdetail) // 'C' rest endpoint for ENTITY: USERDETAIL
    {
        userdetailRepository.save(userdetail);
        return userdetail;
    }

    @GetMapping("get/userdetails")
    public Userdetail getUserDetails(@RequestParam String username) // 'R' rest endpoint for ENTITY: USERDETAIL with CRITERIA: USERNAME
    {
        return userdetailRepository.findById(username).get();
    }

    @GetMapping("getall/userdetails")
    public List<Userdetail> getUserDetails() // 'R' rest endpoint for ENTITY: USERDETAIL
    {
        return userdetailRepository.findAll();
    }

    @PostMapping("set/usertype")
    public ResponseMessage setUsertype(@RequestBody UsernameUsertypeLink usertypeLink)
    {
         Integer tempId = (int) (Math.random()*10000);
         usertypeLink.setId(tempId);
         usertypeLinkRepository.save(usertypeLink);
         ResponseMessage responseMessage = new ResponseMessage();
         responseMessage.setMessage("New Username Usertype Link Created");
         return responseMessage;
    }

    @GetMapping("get/fulluserdetails")
    public FullUserdetail getFullUserDetails(@RequestParam String username) // 'R' rest endpoint for ENTITY: USERDETAIL with CRITERIA: USERNAME
    {
        return userdetailService.composeFullUserDetail(username);
    }


}
