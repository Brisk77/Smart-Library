//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package controller;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import model.LibraryItem;
import model.UserAccount;

public class BorrowController {
    private Queue<UserAccount> reservationQueue = new LinkedList();

    public boolean borrowItem(LibraryItem item, UserAccount user) {
        if (item.isAvailable()) {
            item.setAvailable(false);
            user.borrowItem(item);
            return true;
        } else {
            this.reservationQueue.add(user);
            PrintStream var10000 = System.out;
            String var10001 = user.getName();
            var10000.println(var10001 + " has been added to the waitlist for " + item.getTitle());
            return false;
        }
    }

    public void returnItem(LibraryItem item, UserAccount user) {
        item.setAvailable(true);
        user.returnItem(item);
        if (!this.reservationQueue.isEmpty()) {
            UserAccount nextUser = (UserAccount)this.reservationQueue.poll();
            PrintStream var10000 = System.out;
            String var10001 = nextUser.getName();
            var10000.println("Notifying " + var10001 + " that " + item.getTitle() + " is now available.");
        }

    }
}
