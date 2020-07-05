package cn.fred.service;

public interface UserService {
    boolean login(String username,String passwd);
    boolean register(String username,String passwd);
    void batchAdd(String username,String passwd);
}
