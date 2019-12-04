package org.nh.shiro.shiro;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.nh.shiro.auth.domian.AuthPermission;
import org.nh.shiro.auth.domian.AuthRole;
import org.nh.shiro.auth.domian.AuthUser;
import org.nh.shiro.auth.service.AuthPermissionService;
import org.nh.shiro.auth.service.AuthRoleService;
import org.nh.shiro.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: CustomizeShiroRealm.java
 * @description: Realm的配置
 * @author: yindanqing
 * @create: 2019/12/3 19:44
 */
@Log4j2
public class CustomizeShiroRealm extends AuthorizingRealm {

    public CustomizeShiroRealm() {
        super(null, null);
    }

    public CustomizeShiroRealm(CacheManager cacheManager) {
        super(cacheManager, null);
    }

    public CustomizeShiroRealm(CredentialsMatcher matcher) {
        super(null, matcher);
    }


    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private AuthRoleService authRoleService;

    @Autowired
    private AuthPermissionService authPermissionService;

    /**
     * 设置授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("##################设置授权信息##################");
        AuthUser user = (AuthUser) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleList());
            //用户的权限集合
            info.addStringPermissions(user.getPermissionList());
            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }

    /**
     * 设置认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("##################设置认证信息##################");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        String username = token.getUsername();
        AuthUser authUser = authUserService.getByUserName(username);
        if (authUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<AuthRole> roleList = authRoleService.findByUserId(authUser.getId());
            List<AuthPermission> permissionList = authPermissionService.findByRoleList(roleList.stream().map(AuthRole::getId).collect(Collectors.toList()));
            List<String> roleStrList = roleList.stream().map(AuthRole::getName).collect(Collectors.toList());
            List<String> permissionStrList = permissionList.stream().map(AuthPermission::getName).collect(Collectors.toList());
            authUser.setRoleList(roleStrList);
            authUser.setPermissionList(permissionStrList);
            return new SimpleAuthenticationInfo(authUser, authUser.getPswd(), getName());
        }
        return null;
    }

}
