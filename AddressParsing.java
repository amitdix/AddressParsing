import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressParsing{

    public static void main(String[] args) throws Exception
    {
        System.out.println("please provide full address\n");
        String sampleAddress = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Address address = new Address();
        List<String> listAddress = new ArrayList<String>();
        listAddress = address.parseAddress(sampleAddress);
        if(address.getOrg_name1()!=null)
            System.out.println("Orgnization  : "+ address.getOrg_name1());
        if(address.getOrg_name2()!=null)
            System.out.println("Orgnization  : "+address.getOrg_name2());
        if(address.getStreet_name()!=null)
        System.out.println("Streeet Name : "+address.getStreet_name());
        System.out.println("City         : "+address.getCity());
        if(address.getZipcode()!=null)
            System.out.println("Pin code     : "+address.getZipcode());
        System.out.println("Country      : "+address.getCountry());

    }
}

class Address {

    public Address()
    {
    }
    private String org_name1;
    private String org_name2;
    private String street_name;
    private String city;
    private String zipcode;
    private String country;

    public String getOrg_name1() {
        String regex ="[0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(_listAdress.get(0));
        if(!m.find() && _listAdress.get(0).trim().split(" ").length>1)
            return _listAdress.get(0).toString();
        else
            return null;
    }

    public String getOrg_name2() {
        String regex ="[0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(_listAdress.get(0));
        if(!m.find() && _listAdress.get(1).trim().split(" ").length>1 )
            return _listAdress.get(1).toString();
        else
            return null;
    }

    public String getStreet_name() {
        String regex ="[0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(_listAdress.get(0));
        if(m.find())
            return _listAdress.get(0).toString();
        else
            return null;
    }

    public String getCity() {
        String regex ="[0-9]";
        Pattern p = Pattern.compile(regex);
        for(int i=1; i<_listAdress.size()-1; i++)
        {
            Matcher m = p.matcher(_listAdress.get(i));
            if(!m.find()) {
                city = _listAdress.get(i);
                break;
            }
        }
        return city;
    }

    public String getCountry() {
        return _listAdress.get(_listAdress.size()-1).replace(".", "");
    }

    public String getZipcode() {
        String regex ="[0-9]{5}|[0-9]{2}-|[0-9]{3}";
        Pattern p = Pattern.compile(regex);
        for(int i=2; i<_listAdress.size(); i++)
        {
            Matcher m = p.matcher(_listAdress.get(i));
            if(m.find()) {
                zipcode = _listAdress.get(i);
                break;
            }
        }
        return zipcode;
    }

    private List<String> _listAdress = new ArrayList<String>();

    public List<String> parseAddress(String fullAddressText)
    {
        String[] arrAddress = fullAddressText.split(",");
        for(String address : arrAddress)
        {
            _listAdress.add(address);
        }
        return _listAdress;
    }



}

