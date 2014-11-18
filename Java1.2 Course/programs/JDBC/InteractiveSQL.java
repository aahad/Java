import java.awt.*;
import java.awt.event.*;                 // For event classes
import javax.swing.*;                    // For Swing components
import javax.swing.table.*;              // For the table classes
import java.sql.*;                       // For JDBC classes

public class InteractiveSQL extends JFrame implements ActionListener
{
  public static void main(String[] args)
  { // Create the application object
    // Set default values for the command line args
    String user     = "guest";
    String password = "guest";
    String url      = "jdbc:odbc:technical_library";
    String driver   = "sun.jdbc.odbc.JdbcOdbcDriver";

    // Up to 4 arguments in the sequence database url,driver url, user ID, password
    switch(args.length)
    {
      case 4:                                 // Start here for four arguments
        password = args[3];
        // Fall through to the next case
      case 3:                                 // Start here for three arguments
        user = args[2];
        // Fall through to the next case
      case 2:                                 // Start here for two arguments
        driver = args[1];
        // Fall through to the next case
      case 1:                                 // Start here for one argument
        url = args[0];
    }

    InteractiveSQL theApp = new InteractiveSQL(driver, url, user, password);

    /*InteractiveSQL theApp = new InteractiveSQL("sun.jdbc.odbc.JdbcOdbcDriver",
                                               "jdbc:odbc:technical_library", 
                                               "guest", 
                                               "guest"); */
  }

  public InteractiveSQL(String driver, String url, 
                        String user , String password)
  {
    super("InteractiveSQL");                           // Call base constructor
    setBounds(0, 0, 400, 300);                         // Set window bounds
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);        // Close window operation
    addWindowListener(new WindowHandler());            // Listener for window close

    // Add the input for SQL statements at the top
    command.setToolTipText("Key SQL commmand and press Enter");
    command.addActionListener(this);
    getContentPane().add(command, BorderLayout.NORTH);

    // Add the status reporting area at the bottom
    status.setLineWrap(true);
    status.setWrapStyleWord(true);
    getContentPane().add(status, BorderLayout.SOUTH);

    // Create the menubar from the menu items
    JMenu fileMenu = new JMenu("File");                // Create File menu
    fileMenu.setMnemonic('F');                         // Create shortcut
    clearQueryItem.addActionListener(this);
    exitItem.addActionListener(this);
    fileMenu.add(clearQueryItem);                      // Add clear query item
    fileMenu.add(exitItem);                            // Add exit item
    menuBar.add(fileMenu);                             // Add menu to the menubar
    setJMenuBar(menuBar);                              // Add menubar to the window

    // Establish a database connection and set up the table
    try
    {
      Class.forName(driver);                           // Load the driver
      connection = DriverManager.getConnection(url, user, password);
      statement = connection.createStatement();

      model = new ResultsModel();                  // Create a table model
      JTable table = new JTable(model);            // Create a table from the model
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);   // Use scrollbars
  
      resultsPane = new JScrollPane(table);        // Create scrollpane for table
      getContentPane().add(resultsPane, BorderLayout.CENTER);

    }
    catch(ClassNotFoundException cnfe)
    {
      System.err.println(cnfe);                    // Driver not found
    }
    catch(SQLException sqle)
    {
      System.err.println(sqle);                    // error connection to database
    }

    pack();

    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();
    if(source == command)                       // Enter key for text field input
      executeSQL();

    else if(source == clearQueryItem)           // Clear query menu item
      command.setText("");                      // Clear SQL entry

    else if(source == exitItem)                 // Exit menu item
    {
      dispose();                                 // Release the window resources
      System.exit(0);                            // End the application
    }    
  }


  public void executeSQL()
  {
    String query = command.getText();      // Get the SQL statement
    if(query == null)                      // If there's nothing we are done
      return;
    try
    {
      model.setResultSet(statement.executeQuery(query));
      status.setText("Resultset has " + model.getRowCount() + " rows.");
    }
    catch (SQLException sqle)
    {
      status.setText(sqle.getMessage());        // Display error message
    }
  }


  class WindowHandler extends WindowAdapter
  {
    // Handler for window closing event
    public void windowClosing(WindowEvent e)
    {
      dispose();                                 // Release the window resources
      System.exit(0);                            // End the application
    }
  }

  JTextField command = new JTextField();       // Input area for SQL
  JTextArea status = new JTextArea(3,1);       // Output area for status and errors
  JScrollPane resultsPane;

  JMenuBar menuBar = new JMenuBar();                        // The menu bar
  JMenuItem clearQueryItem = new JMenuItem("Clear query");  // Clear SQL item
  JMenuItem exitItem = new JMenuItem("Exit");               // Exit item

  Connection connection;                       // Connection to the database
  Statement statement;                         // Statement object for queries
  ResultsModel model;                          // Table model for resultset
}
