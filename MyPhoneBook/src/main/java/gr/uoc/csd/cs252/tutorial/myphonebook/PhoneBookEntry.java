package gr.uoc.csd.cs252.tutorial.myphonebook;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;

/**
 * @author Yannis Marketakis (marketak 'at' ics 'dot' forth 'dot' gr)
 */
public class PhoneBookEntry {
    private String name;
    private Multimap<PhoneType,String> phoneNumbers;
    
    public PhoneBookEntry(String aName){
        this.name=aName;
        this.phoneNumbers=HashMultimap.create();
    }
    
    public PhoneBookEntry(String aName, PhoneType phoneType, String aPhoneNum){
        this(aName);
        this.phoneNumbers.put(phoneType, aPhoneNum);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPhoneNumber(PhoneType phoneType, String phoneNumber) {
        this.phoneNumbers.put(phoneType, phoneNumber);
    }

    public Collection<String> getPhoneNumbers() {
        return this.phoneNumbers.values();
    }
    
    public Collection<String> getPhoneNumbers(PhoneType phoneType) {
        return this.phoneNumbers.get(phoneType);
    }
    
    protected enum PhoneType{
        MOBILE,
        HOME,
        WORK,
        OTHER
    }
}
