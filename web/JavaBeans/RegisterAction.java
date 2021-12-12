package JavaBeans;

import DAO.UserDao;
import VO.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class RegisterAction {
    private String account;
    private String password;
    private String confirm;
    private String username;

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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String execute() throws Exception{
        String registerState="";
        String actionUrl="RegisterFail";
        UserDao userDao=new UserDao();

        //判断输入信息是否正确
        if(account.isEmpty() || password.isEmpty() || confirm.isEmpty() || username.isEmpty()){
            registerState="输入的信息不能为空，请重新输入";
        }else if(!password.equals(confirm)){
            registerState="您的密码出现错误，请重新输入";
        }else {
            ArrayList<User> users=null;
            try {
                users=userDao.getAllUser();
            }catch (Exception e){
                e.printStackTrace();
            }
            //检查该用户是否已经注册
            for(int i=0;i<users.size();i++){
                User user=users.get(i);
                if(account.equals(user.getAccount())){
                    registerState="您的账号已存在，请重新输入";
                }else if(username.equals(user.getUsername())){
                    registerState="您的注册姓名已存在，请重新输入";
                }
            }
        }
        //当输入信息没有问题时进行注册
        if(registerState.isEmpty()){
            User user=new User(account,password,username);
            try {
                userDao.addUser(user);
            }catch (Exception e){
                e.printStackTrace();
            }
            registerState="您已成功注册";
            actionUrl="RegisterSuccess";
        }
        //存储状态信息与返回
        HttpServletRequest request= ServletActionContext.getRequest();
        request.setAttribute("RegisterState",registerState);
        return actionUrl;
    }
}
