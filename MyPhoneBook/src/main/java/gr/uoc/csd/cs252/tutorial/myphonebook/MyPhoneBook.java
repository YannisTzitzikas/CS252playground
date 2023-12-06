package gr.uoc.csd.cs252.tutorial.myphonebook;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

/**
 * @author Yannis Marketakis (marketak 'at' ics 'dot' forth 'dot' gr)
 */
public class MyPhoneBook {
    private static final String PHONEBOOK_TITLE="My Super PhoneBook";
    private Collection<PhoneBookEntry> phoneBookEntries;
    
    public MyPhoneBook(){
        this.phoneBookEntries=new HashSet<>();
    }
    
    public MyPhoneBook loadWithTestData(){
        PhoneBookEntry bobEntry=new PhoneBookEntry("Bob",PhoneBookEntry.PhoneType.MOBILE,"+30111111111");
        bobEntry.addPhoneNumber(PhoneBookEntry.PhoneType.MOBILE,"+30222222222");
        bobEntry.addPhoneNumber(PhoneBookEntry.PhoneType.HOME,"+3033333333");
        
        PhoneBookEntry aliceEntry=new PhoneBookEntry("Alice",PhoneBookEntry.PhoneType.MOBILE,"+30444444444");
        
        PhoneBookEntry eveEntry=new PhoneBookEntry("Eve",PhoneBookEntry.PhoneType.MOBILE,"+30555555555");
        eveEntry.addPhoneNumber(PhoneBookEntry.PhoneType.MOBILE, "+30666666666");
        eveEntry.addPhoneNumber(PhoneBookEntry.PhoneType.MOBILE, "+30777777777");
        eveEntry.addPhoneNumber(PhoneBookEntry.PhoneType.WORK, "+30888888888");
        
        this.phoneBookEntries.add(bobEntry);
        this.phoneBookEntries.add(aliceEntry);
        this.phoneBookEntries.add(eveEntry);   
        
        return this;
    }

    public String lookUpForName(String phoneNumber){
        Optional<PhoneBookEntry> pbEntryFound=this.phoneBookEntries.stream()
                                                                    .filter(phoneBookEntry -> phoneBookEntry.getPhoneNumbers().contains(phoneNumber))
                                                                    .findFirst();
        if(pbEntryFound.isPresent()){
            return pbEntryFound.get().getName();
        }else{
            return null;
        }
    }
    
    public Collection<String> lookUpForPhone(String name){
        Optional<PhoneBookEntry> pbEntryFound=this.phoneBookEntries.stream()
                                                                    .filter(phoneBookEntry -> phoneBookEntry.getName().equalsIgnoreCase(name))
                                                                    .findFirst();
        if(pbEntryFound.isPresent()){
            return pbEntryFound.get().getPhoneNumbers();
        }else{
            return null;
        }
    }
    
    public Collection<String> lookUpForPhone(String name, PhoneBookEntry.PhoneType phoneType){
        Optional<PhoneBookEntry> pbEntryFound=this.phoneBookEntries.stream()
                                                                    .filter(phoneBookEntry -> phoneBookEntry.getName().equalsIgnoreCase(name) && !phoneBookEntry.getPhoneNumbers(phoneType).isEmpty())
                                                                    .findFirst();
        if(pbEntryFound.isPresent()){
            return pbEntryFound.get().getPhoneNumbers(phoneType);
        }else{
            return null;
        }   
    }
    
    public static void main(String[] args){
        MyPhoneBook myPb=new MyPhoneBook().loadWithTestData();
        
        System.out.println(myPb.lookUpForName("+30222222222"));
        System.out.println(myPb.lookUpForName("+30444444444"));
        System.out.println(myPb.lookUpForName("+30777777777"));
        System.out.println(myPb.lookUpForPhone("Alice"));
        System.out.println(myPb.lookUpForPhone("Eve",PhoneBookEntry.PhoneType.MOBILE));
        System.out.println(myPb.lookUpForPhone("Eve",PhoneBookEntry.PhoneType.HOME));
        System.out.println(myPb.lookUpForPhone("Eve",PhoneBookEntry.PhoneType.WORK));
    }
}
