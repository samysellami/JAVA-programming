// @SuppressWarnings("unchecked")
class MainApp {
    public static void main (String[] args) {
        Library myLib = new Library();
        myLib.addMedia(new Book("Author1", "Title1"));
        myLib.addMedia(new Book("Author2", "Title2"));
        myLib.addMedia(new Book("Author3", "Title3"));

        Media lastItem = (Book) myLib.retrieveLast();
        System.out.println(
            lastItem.getClass().getName() + " : " +
            lastItem.getTitle() + " by " +
            lastItem.getAuthor()
        );
    }
}

// class MainApp {
//   public static void main (String[] args) {
//       GenericLibrary<Book> myLib = new GenericLibrary<>();
//       myLib.addMedia(new Book("Author1", "Title1"));
//       myLib.addMedia(new Book("Author2", "Title2"));
//       myLib.addMedia(new Book("Author3", "Title3"));

//       Media lastItem = myLib.retrieveLast();
//       System.out.println(
//           lastItem.getClass().getName() + " : " +
//           lastItem.getTitle() + " by " +
//           lastItem.getAuthor()
//       );
//   }
// }
