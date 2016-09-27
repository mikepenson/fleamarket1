package cn.melonydi.fleamarket.service.impl;

import org.springframework.stereotype.Service;

import cn.melonydi.fleamarket.model.Admin;
import cn.melonydi.fleamarket.service.AdminService;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
	public AdminServiceImpl() {
		super();
	}

}
