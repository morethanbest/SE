package init;

import util.Logger;

/**
 * Created by Administrator on 2015/11/23.
 */
public class Server {

    public static void main(String[] args) {
        try {
            Logger.info("Try start server...");
            ServerRMIHelper.init();
            Logger.info("Server is now running!");
        } catch (ServerInitException e) {
            Logger.error("Server starts fail!");
            Logger.error(e);
        }
    }
}
