public class BorrowController {
    private Queue<UserAccount> reservationQueue;

    public BorrowController() {
        this.reservationQueue = new LinkedList<>();
    public boolean borrowItem(LibraryItem item, UserAccount user) {
        if (item.isAvailable()) {
            item.setAvailable(false);
            user.borrowItem(item);
            return true;
        } else {
            reservationQueue.add(user);
            System.out.println(user.getName() + " has been added to the waitlist for " + item.getTitle());
            return false;
        }
    }

    public void returnItem(LibraryItem item, UserAccount user) {
        item.setAvailable(true);
        user.returnItem(item);
        if (!reservationQueue.isEmpty()) {
            UserAccount nextUser = reservationQueue.poll();
            System.out.println("Notifying " + nextUser.getName() + " that " + item.getTitle() + " is now available.");
        }
    }
