/* Make a class Shop ( use Singleton ), class Worker which should be inherited from two more classes:
 * Marketing Specialist (spends from the bodget ) and Sales (sells and increases the budget).
 * Class Shop should have a method which shloud return the Shop's current budget amount
 */

import java.util.*;

public class theShop {
    public static class Shop {
        private static Shop instance = null;
        private double turnOver = 0.0;

        private Shop() {

        }
     
        public static Shop getInstance() {
            if (instance == null) {
               instance = new Shop();
            }
     
            return instance;
        }
     
        private List workers = new ArrayList();
     
                public void addWorker(Object worker) {
            this.workers.add(worker);
        }
     
        public double getTurnover() {
            for (var worker : this.workers) {
                this.turnOver += ((Worker)worker).getMoney();
            }
     
            return turnOver;
        }
    }

    public static class Worker {
        private Shop workingShop;
        private double budget;

        public Worker () {
            this.workingShop =  Shop.getInstance();
             this.workingShop.addWorker(this);
        }

        public double getMoney() {
            return this.budget;
        }


    }
    
    static class SalesConsultant extends Worker {
        
         public  SalesConsultant() {
            super();
            super.budget = 0.0;
         }
        
     
         public void sellProduct(double price) {
             super.budget += Math.max(price, 0);
         }
     
     }
     
     static class MarketingSpecialist extends Worker {
     
                public MarketingSpecialist() {
                super();
                super.budget = 5000.00;
         }
     
         public void spendMoney(double marketingCampaignCost) {
             super.budget -= Math.max(marketingCampaignCost, 0);
         }
     
         }
    
    public static void main (String args []){
        SalesConsultant ss = new SalesConsultant();
        MarketingSpecialist mm = new MarketingSpecialist();

        mm.spendMoney(1500.0);
        ss.sellProduct(500.0);
        System.out.println(Shop.getInstance().getTurnover());

    }

}