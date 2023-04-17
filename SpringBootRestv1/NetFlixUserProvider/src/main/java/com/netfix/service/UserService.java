package com.netfix.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.netfix.model.NetFlixAdminUser;

@Service
public class UserService {
	
	static List<NetFlixAdminUser> nfa=new ArrayList<>();
	
	static Integer count=0;
	
	static {
		nfa.add(new NetFlixAdminUser(++count,"Rama",LocalDate.now().minusYears(3)));
		nfa.add(new NetFlixAdminUser(++count,"Venky",LocalDate.now().minusYears(2)));
		nfa.add(new NetFlixAdminUser(++count,"David",LocalDate.now().minusYears(1)));
	}
	
	public static List<NetFlixAdminUser> findAll(){
		return nfa;
	}
	
	public static NetFlixAdminUser findById(int id) {
	    Predicate<? super NetFlixAdminUser> predicate=user->user.getUid().equals(id);
	    return nfa.stream().filter(predicate).findFirst().orElse(null);
	}

	public static void createUser(NetFlixAdminUser netFlixAdminUser) {
		netFlixAdminUser.setUid(++count);
		nfa.add(netFlixAdminUser);
	}

	public static void deleteUser(int id) {
	    Predicate<? super NetFlixAdminUser> predicate=user->user.getUid().equals(id);
	    nfa.removeIf(predicate);
	}
	
}
