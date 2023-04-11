package com.cbt.cbtskillwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserdetailService
{
    @Autowired
    UserdetailRepository userdetailRepository;

    @Autowired
    UsernameUsertypeLinkRepository usertypeLink;

    public FullUserdetail composeFullUserDetail(String username)
    {
        Userdetail tempUserdetail = userdetailRepository.findById(username).get();
        List<UsernameUsertypeLink> usertypeLinkList =  usertypeLink.findAll();

        List<UsernameUsertypeLink> finalLinkList = usertypeLinkList.stream().filter((UsernameUsertypeLink link)->{
            return link.getUsername().equals(username);
        }).toList();

        FullUserdetail fullUserdetail =  new FullUserdetail();
        fullUserdetail.setUsername(tempUserdetail.getUsername());
        fullUserdetail.setFirstname(tempUserdetail.getFirstname());
        fullUserdetail.setLastname(tempUserdetail.getLastname());
        fullUserdetail.setEmail(tempUserdetail.getEmail());
        fullUserdetail.setPhone(tempUserdetail.getPhone());
        fullUserdetail.setCity(tempUserdetail.getCity());
        fullUserdetail.setCountry(tempUserdetail.getCountry());

        List<String> tempTypes = finalLinkList.stream().map((UsernameUsertypeLink link) ->{ return link.getUsertype();}).toList();

        fullUserdetail.setUsertypes(tempTypes);

        return fullUserdetail;


    }
}
