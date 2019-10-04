package nl.multicode.bsn;

import nl.multicode.bsn.model.BurgeServiceNummer;
import nl.multicode.bsn.service.BsnService;

public class App {
    public static void main(String[] args) {
        BsnService bsnService = new BsnService();
        if (args != null && args.length == 2 && args[0].equalsIgnoreCase("validate")) {
            String valid = bsnService.isValidBsn(new BurgeServiceNummer(args[1])) ? "valid" : "invalid";
            System.out.println(args[1] + " is " + valid + " bsn");
        } else {
            System.out.println(bsnService.generateBsn());
        }
    }
}
