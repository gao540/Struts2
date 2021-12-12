package JavaBeans;

import DAO.UserDao;
import VO.User;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;

public class LoginAction {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception{
        String loginState="";
        String actionUrl="LoginFail";
        UserDao userDao=new UserDao();
        //判断输入信息是否有误
        if(account.isEmpty() || password.isEmpty()){
            loginState="输入的信息不能为空，请重新输入";
        }
        //判断输入账号是否正确
        if(loginState.isEmpty()){
            User user=null;
            try{
                user=userDao.getUser(account);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(user==null || !user.getPassword().equals(password)){
                loginState="账号或者密码错误";
            }else {
                loginState="登录成功";
                actionUrl="LoginSuccess";
            }
        }
        //存储状态信息与返回
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("LoginState",loginState);
        return actionUrl;
    }
}
