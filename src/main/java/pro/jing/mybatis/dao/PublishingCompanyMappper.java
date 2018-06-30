package pro.jing.mybatis.dao;

import pro.jing.mybatis.bean.PublishingCompany;

public interface PublishingCompanyMappper {

	PublishingCompany getCompanyById(Integer id);
	
	PublishingCompany getCompanyByIdWithBookList(Integer id);
	
	// select by pc id
	PublishingCompany getCompanyByIdWithBookList01(Integer id);
}
