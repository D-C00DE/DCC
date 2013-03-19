package dcc.dcfg;

/**
 * @author dusakusD
 */
public class Cob {
   public String name;
   
   public boolean valueB;
   public int valueI;
   public double valueD;
   public String valueS;
   
   public Cob(String nameI){
       name = nameI;
   }
   public Cob(String nameI, boolean value){
       name = nameI;
       valueB = value;
   }
   public Cob(String nameI, int value){
       name = nameI;
       valueI = value;
   }
   public Cob(String nameI, double value){
       name = nameI;
       valueD = value;
   }
   public Cob(String nameI, String value){
       name = nameI;
       valueS = value;
   }
}
