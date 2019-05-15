package com.wtu.jht.bookmanage.serviceImpl;

import com.wtu.jht.bookmanage.dao.TResourceMapper;
import com.wtu.jht.bookmanage.dao.TUserMapper;
import com.wtu.jht.bookmanage.dao.extend.TResourceExtMapper;
import com.wtu.jht.bookmanage.modal.TResource;
import com.wtu.jht.bookmanage.modal.TResourceExample;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.modal.TUserExample;
import com.wtu.jht.bookmanage.openapi.db.api.DBInterface;
import com.wtu.jht.bookmanage.openapi.service.base.ParentServiceImpl;
import com.wtu.jht.bookmanage.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TUserServiceImpl extends ParentServiceImpl<TUser> implements TUserService {

    private static Logger logger = LoggerFactory.getLogger(TUserServiceImpl.class);

    private final TUserMapper tUserMapper;

    private final TResourceExtMapper tResourceExtMapper;

    @Autowired
    public TUserServiceImpl(TUserMapper tUserMapper,
                            TResourceExtMapper tResourceExtMapper){
        this.tUserMapper=tUserMapper;
        this.tResourceExtMapper=tResourceExtMapper;
    }

    @Override
    public TUser selectByUserAccount(String username) {
        try {
            if (StringUtils.isNoneBlank(username)) {
                TUserExample example = new TUserExample();
                example.createCriteria().andUsernameEqualTo(username);
                List<TUser> userList = tUserMapper.selectByExample(example);
                System.out.println(userList.get(0).getfId());
                if (userList != null && userList.size() == 1) {
                    return userList.get(0);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public List<TResource> selectResource(Integer userId) {
        return tResourceExtMapper.selectByUserId(userId);
    }

    @Override
    protected DBInterface<TUser> getDao() {
        return tUserMapper;
    }
}
