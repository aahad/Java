package HTML;

public class HTMLRadioButtonInput extends HTMLInput {

  private boolean checked = false;

  // Default Constructor
  public HTMLRadioButtonInput() {

    setType("RADIO");
  }

  // Set checked to true/false
  public void setChecked(boolean value) {

    checked = value;
  }

  // Check to see if RadioButton is CHECKED
  public boolean isChecked() {

    return checked;
  }

  // Return String containing the HTML formatted Radio Button
  public String toHTML() {

    if ( checked ) {

      setAttributes(" CHECKED");
    }
    return super.toHTML();
  }
}