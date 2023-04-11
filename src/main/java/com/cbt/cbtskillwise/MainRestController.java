package com.cbt.cbtskillwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
