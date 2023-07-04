package com.yedam.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class productInfoControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String prodCode = req.getParameter("prodCode");
		ProductService svc = new ProductServiceImpl();
		ProductVO result = svc.getProduct(prodCode);
		
		List<ProductVO> list = svc.likeList();
		
		req.setAttribute("product", result);
		req.setAttribute("list", list);
		
		return "product/prodInfo.tiles";
	}

}
