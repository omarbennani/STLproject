package egg;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class MiniJavaMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "MiniJava";
  private MiniJavaMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, egg.MiniJavaMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String CLASS_nom_constructeur_incorrect;
  public static  String MiniJava_unexpected_token;
  public static  String Interface_undefined_ident;
  public static  String variable_already_defined;
  public static  String Signature_ident_already_defined;
  public static  String MiniJava_expected_eof;
  public static  String Identificateur_Type_undefined;
  public static  String NOT_DEFINED_CLASS_OR_INTERFACE;
  public static  String instruction_expression;
  public static  String UNDEFINED_METHOD_OR_SIGNATURE;
  public static  String NOT_DEFINED_ATTRIBUT_OR_VARIABLE;
  public static  String PARAM_already_defined;
  public static  String field_ident_already_defined;
  public static  String CLASS_attribut_already_defined;
  public static  String MiniJava_expected_token;
  public static  String already_defined_ident;
  public static  String expression_affectation;
  public static  String NOT_AN_OBJECT;
  public static  String Class_already_defined;
  public static  String Class_Interface_ident_conflict;
  public static  String CLASS_undefined_ident;
  }
