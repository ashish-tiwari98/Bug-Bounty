public class BugTrackingBoImpl implements BugTrackingBo{

    @Override
    public bool showRegisterStatus(User user){

        BugTrackingDao btdao = new BugTrackingDaoImpl();
        return btdao.showRegStatus(user);
    }
    
}
