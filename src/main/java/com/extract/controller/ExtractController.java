package com.extract.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.extract.dto.DtoRequest;
import com.extract.dto.IdNameAndAddressResponse;
import com.extract.dto.NameRespone;
import com.extract.dto.SortResponse;
import com.extract.entity.ManagersEntity;
import com.extract.entity.User;
import com.extract.repository.ManagerRepository;
import com.extract.repository.UserRepository;

@RestController
public class ExtractController {
	@Autowired
	UserRepository user;

	@Autowired
	ManagerRepository managersRepo;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean home(@RequestBody List<DtoRequest> name) {
		List<User> res = new ArrayList<>();
		for (DtoRequest req : name) {
			User us = new User();
			us.setName(req.getName());
			us.setId(req.getId());
			us.setAge(req.getAge());
			res.add(us);
		}
		user.save(res);
		return true;
	}

	@RequestMapping(value = "/findall")
	public List<User> find() {
		return user.findAll();

	}

	@RequestMapping(value = "/findname/{name}")
	public User getAttributeDetails(@PathVariable String name) {
		try {
			return (User) user.findByName(name);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/findnameAndId/{name}")
	public SortResponse getIdandNameDetails(@PathVariable String name) {
		try {
			User nn = user.findByName(name);
			SortResponse res = new SortResponse();
			res.setId(nn.getId());
			res.setName(nn.getName());
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/findnameAndSort")
	public List<SortResponse> getIdandNameSort() {
		try {
			List<SortResponse> rs = new ArrayList<>();
			List<User> nn = user.findAllByOrderByNameAsc();
			for (User list : nn) {
				SortResponse res = new SortResponse();
				res.setId(list.getId());
				res.setName(list.getName());
				rs.add(res);
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@RequestMapping(value = "/findAddressAndSort")
	public List<IdNameAndAddressResponse> getIdNameAndAdrressdetsil() {
		List<IdNameAndAddressResponse> inas = new ArrayList<>();
		List<User> us = user.findAllByOrderByAddressAsc();
		for (User list : us) {
			IdNameAndAddressResponse ina = new IdNameAndAddressResponse();
			ina.setId(list.getId());
			ina.setName(list.getName());
			ina.setAddress(list.getAddress());
			inas.add(ina);
		}
		return inas;
	}

	@RequestMapping(value = "/findNameDescSort")
	public List<NameRespone> getNameSort() {
		List<NameRespone> rs = new ArrayList<>();
		List<User> us = user.findAllByOrderByNameDesc();
		for (User list : us) {
			NameRespone nr = new NameRespone();
			nr.setName(list.getName());
			rs.add(nr);
		}
		return rs;
	}

	@RequestMapping(value = "/findFirstName/{office}")
	public ManagersEntity getFirstName(@PathVariable String office) {
		return (ManagersEntity) managersRepo.findByOffice(office);
	}
}
