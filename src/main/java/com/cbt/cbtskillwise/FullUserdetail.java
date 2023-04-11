package com.cbt.cbtskillwise;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FullUserdetail extends Userdetail // Composed Entity from TABLES: USERDETAILS, USERNAME_USERTYPE_LINK
{
    List<String> usertypes;
}
