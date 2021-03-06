package ghostysoft.bleuuidexplorer;

/**
 * Created by ghosty on 2015/2/28.
 */

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */

public class GattAttributes {
    private final static String TAG = GattAttributes.class.getSimpleName();

    private static HashMap<String, String> attributes = new HashMap();
    public static List<uartChar> uarts = new ArrayList<>(); // <Service,Rx,Tx>

    //public static UUID UUID_HEART_RATE_MEASUREMENT = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
    public static UUID UUID_CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    public static int IsUartService(UUID uuid) {
        for (int i=0; i<uarts.size(); i++) {
            if (uuid.equals(UUID.fromString(uarts.get(i).Service)))
                return i;
        }
        return -1;
    }

    public static int IsUartCharacteristic(UUID uuid) {
        for (int i=0; i<uarts.size(); i++) {
            if (uuid.equals(UUID.fromString(uarts.get(i).RxChar)) || uuid.equals(UUID.fromString(uarts.get(i).TxChar)))
                return i;
        }
        return -1;
    }

    public static int IsUartRxCharacteristic(UUID uuid) {
        for (int i=0; i<uarts.size(); i++) {
            if (uuid.equals(UUID.fromString(uarts.get(i).RxChar)))
                return i;
        }
        return -1;
    }

    public static int IsUartTxCharacteristic(UUID uuid) {
        for (int i=0; i<uarts.size(); i++) {
            if (uuid.equals(UUID.fromString(uarts.get(i).TxChar)))
                return i;
        }
        return -1;
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }

    static {
        //uarts.add(new uartChar(Service UUID, RX UUID, TX UUID ));      // RX=Write/writeNoResponse, TX=Notify/Indication
        uarts.add(new uartChar("6e400001-b5a3-f393-e0a9-e50e24dcca9e","6e400002-b5a3-f393-e0a9-e50e24dcca9e","6e400003-b5a3-f393-e0a9-e50e24dcca9e"));      //Nordic
        uarts.add(new uartChar("49535343-fe7d-4ae5-8fa9-9fafd205e455", "49535343-8841-43f4-a8d4-ecbe34729bb3", "49535343-1e4d-4bd9-ba61-23c647249616"));  //ISSC
        uarts.add(new uartChar("0000fff0-0000-1000-8000-00805f9b34fb", "0000fff1-0000-1000-8000-00805f9b34fb", "0000fff2-0000-1000-8000-00805f9b34fb"));  //ISSC Trandparent
        uarts.add(new uartChar("0000ffe0-0000-1000-8000-00805f9b34fb","0000ffe1-0000-1000-8000-00805f9b34fb","0000ffe1-0000-1000-8000-00805f9b34fb")); //HM-10
        uarts.add(new uartChar("0000fefb-0000-1000-8000-00805f9b34fb","00000001-0000-1000-8000-008025000000","00000002-0000-1000-8000-008025000000")); //Stollmann Terminal IO
        uarts.add(new uartChar("569a1101-b87f-490c-92cb-11ba5ea5167c","569a2001-b87f-490c-92cb-11ba5ea5167c","569a2000-b87f-490c-92cb-11ba5ea5167c")); //Laird BL600 Virtual Serial Port Service
    }

    static {
        // Sample Services.
        attributes.put("00001800-0000-1000-8000-00805f9b34fb", "Generic Access");
        attributes.put("00001801-0000-1000-8000-00805f9b34fb", "Generic Attribute");
        attributes.put("00001802-0000-1000-8000-00805f9b34fb", "Immediate Alert");
        attributes.put("00001803-0000-1000-8000-00805f9b34fb", "Link Loss");
        attributes.put("00001804-0000-1000-8000-00805f9b34fb", "Tx Power");
        attributes.put("00001805-0000-1000-8000-00805f9b34fb", "Current Time Service");
        attributes.put("00001806-0000-1000-8000-00805f9b34fb", "Reference Time Update Service");
        attributes.put("00001807-0000-1000-8000-00805f9b34fb", "Next DST Change Service");
        attributes.put("00001808-0000-1000-8000-00805f9b34fb", "Glucose");
        attributes.put("00001809-0000-1000-8000-00805f9b34fb", "Health Thermometer");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information");
        attributes.put("0000180b-0000-1000-8000-00805f9b34fb", "Network Availability");
        attributes.put("0000180c-0000-1000-8000-00805f9b34fb", "Watchdog");
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate");
        attributes.put("0000180e-0000-1000-8000-00805f9b34fb", "Phone Alert Status Service");
        attributes.put("0000180f-0000-1000-8000-00805f9b34fb", "Battery Service");
        attributes.put("00001810-0000-1000-8000-00805f9b34fb", "Blood Pressure");
        attributes.put("00001811-0000-1000-8000-00805f9b34fb", "Alert Notification Service");
        attributes.put("00001812-0000-1000-8000-00805f9b34fb", "Human Interface Device");
        attributes.put("00001813-0000-1000-8000-00805f9b34fb", "Scan Parameters");
        attributes.put("00001814-0000-1000-8000-00805f9b34fb", "Running Speed and Cadence");
        attributes.put("00001815-0000-1000-8000-00805f9b34fb", "Automation IO");
        attributes.put("00001816-0000-1000-8000-00805f9b34fb", "Cycling Speed and Cadence");
        attributes.put("00001818-0000-1000-8000-00805f9b34fb", "Cycling Power");
        attributes.put("00001819-0000-1000-8000-00805f9b34fb", "Location and Navigation");
        attributes.put("0000181a-0000-1000-8000-00805f9b34fb", "Environmental Sensing");
        attributes.put("0000181b-0000-1000-8000-00805f9b34fb", "Body Composition");
        attributes.put("0000181c-0000-1000-8000-00805f9b34fb", "User Data");
        attributes.put("0000181d-0000-1000-8000-00805f9b34fb", "Weight Scale");
        attributes.put("0000181e-0000-1000-8000-00805f9b34fb", "Bond Management");
        attributes.put("0000181f-0000-1000-8000-00805f9b34fb", "Continuous Glucose Monitoring");
        attributes.put("00001820-0000-1000-8000-00805f9b34fb", "Internet Protocol Support");
        attributes.put("00002700-0000-1000-8000-00805f9b34fb", "unitless");
        attributes.put("00002701-0000-1000-8000-00805f9b34fb", "length (metre)");
        attributes.put("00002702-0000-1000-8000-00805f9b34fb", "mass (kilogram)");
        attributes.put("00002703-0000-1000-8000-00805f9b34fb", "time (second)");
        attributes.put("00002704-0000-1000-8000-00805f9b34fb", "electric current (ampere)");
        attributes.put("00002705-0000-1000-8000-00805f9b34fb", "thermodynamic temperature (kelvin)");
        attributes.put("00002706-0000-1000-8000-00805f9b34fb", "amount of substance (mole)");
        attributes.put("00002707-0000-1000-8000-00805f9b34fb", "luminous intensity (candela)");
        attributes.put("00002710-0000-1000-8000-00805f9b34fb", "area (square metres)");
        attributes.put("00002711-0000-1000-8000-00805f9b34fb", "volume (cubic metres)");
        attributes.put("00002712-0000-1000-8000-00805f9b34fb", "velocity (metres per second)");
        attributes.put("00002713-0000-1000-8000-00805f9b34fb", "acceleration (metres per second squared)");
        attributes.put("00002714-0000-1000-8000-00805f9b34fb", "wavenumber (reciprocal metre)");
        attributes.put("00002715-0000-1000-8000-00805f9b34fb", "density (kilogram per cubic metre)");
        attributes.put("00002716-0000-1000-8000-00805f9b34fb", "surface density (kilogram per square metre)");
        attributes.put("00002717-0000-1000-8000-00805f9b34fb", "specific volume (cubic metre per kilogram)");
        attributes.put("00002718-0000-1000-8000-00805f9b34fb", "current density (ampere per square metre)");
        attributes.put("00002719-0000-1000-8000-00805f9b34fb", "magnetic field strength (ampere per metre)");
        attributes.put("0000271a-0000-1000-8000-00805f9b34fb", "amount concentration (mole per cubic metre)");
        attributes.put("0000271b-0000-1000-8000-00805f9b34fb", "mass concentration (kilogram per cubic metre)");
        attributes.put("0000271c-0000-1000-8000-00805f9b34fb", "luminance (candela per square metre)");
        attributes.put("0000271d-0000-1000-8000-00805f9b34fb", "refractive index");
        attributes.put("0000271e-0000-1000-8000-00805f9b34fb", "relative permeability");
        attributes.put("00002720-0000-1000-8000-00805f9b34fb", "plane angle (radian)");
        attributes.put("00002721-0000-1000-8000-00805f9b34fb", "solid angle (steradian)");
        attributes.put("00002722-0000-1000-8000-00805f9b34fb", "frequency (hertz)");
        attributes.put("00002723-0000-1000-8000-00805f9b34fb", "force (newton)");
        attributes.put("00002724-0000-1000-8000-00805f9b34fb", "pressure (pascal)");
        attributes.put("00002725-0000-1000-8000-00805f9b34fb", "energy (joule)");
        attributes.put("00002726-0000-1000-8000-00805f9b34fb", "power (watt)");
        attributes.put("00002727-0000-1000-8000-00805f9b34fb", "electric charge (coulomb)");
        attributes.put("00002728-0000-1000-8000-00805f9b34fb", "electric potential difference (volt)");
        attributes.put("00002729-0000-1000-8000-00805f9b34fb", "capacitance (farad)");
        attributes.put("0000272a-0000-1000-8000-00805f9b34fb", "electric resistance (ohm)");
        attributes.put("0000272b-0000-1000-8000-00805f9b34fb", "electric conductance (siemens)");
        attributes.put("0000272c-0000-1000-8000-00805f9b34fb", "magnetic flux (weber)");
        attributes.put("0000272d-0000-1000-8000-00805f9b34fb", "magnetic flux density (tesla)");
        attributes.put("0000272e-0000-1000-8000-00805f9b34fb", "inductance (henry)");
        attributes.put("0000272f-0000-1000-8000-00805f9b34fb", "Celsius temperature (degree Celsius)");
        attributes.put("00002730-0000-1000-8000-00805f9b34fb", "luminous flux (lumen)");
        attributes.put("00002731-0000-1000-8000-00805f9b34fb", "illuminance (lux)");
        attributes.put("00002732-0000-1000-8000-00805f9b34fb", "activity referred to a radionuclide (becquerel)");
        attributes.put("00002733-0000-1000-8000-00805f9b34fb", "absorbed dose (gray)");
        attributes.put("00002734-0000-1000-8000-00805f9b34fb", "dose equivalent (sievert)");
        attributes.put("00002735-0000-1000-8000-00805f9b34fb", "catalytic activity (katal)");
        attributes.put("00002740-0000-1000-8000-00805f9b34fb", "dynamic viscosity (pascal second)");
        attributes.put("00002741-0000-1000-8000-00805f9b34fb", "moment of force (newton metre)");
        attributes.put("00002742-0000-1000-8000-00805f9b34fb", "surface tension (newton per metre)");
        attributes.put("00002743-0000-1000-8000-00805f9b34fb", "angular velocity (radian per second)");
        attributes.put("00002744-0000-1000-8000-00805f9b34fb", "angular acceleration (radian per second squared)");
        attributes.put("00002745-0000-1000-8000-00805f9b34fb", "heat flux density (watt per square metre)");
        attributes.put("00002746-0000-1000-8000-00805f9b34fb", "heat capacity (joule per kelvin)");
        attributes.put("00002747-0000-1000-8000-00805f9b34fb", "specific heat capacity (joule per kilogram kelvin)");
        attributes.put("00002748-0000-1000-8000-00805f9b34fb", "specific energy (joule per kilogram)");
        attributes.put("00002749-0000-1000-8000-00805f9b34fb", "thermal conductivity (watt per metre kelvin)");
        attributes.put("0000274a-0000-1000-8000-00805f9b34fb", "energy density (joule per cubic metre)");
        attributes.put("0000274b-0000-1000-8000-00805f9b34fb", "electric field strength (volt per metre)");
        attributes.put("0000274c-0000-1000-8000-00805f9b34fb", "electric charge density (coulomb per cubic metre)");
        attributes.put("0000274d-0000-1000-8000-00805f9b34fb", "surface charge density (coulomb per square metre)");
        attributes.put("0000274e-0000-1000-8000-00805f9b34fb", "electric flux density (coulomb per square metre)");
        attributes.put("0000274f-0000-1000-8000-00805f9b34fb", "permittivity (farad per metre)");
        attributes.put("00002750-0000-1000-8000-00805f9b34fb", "permeability (henry per metre)");
        attributes.put("00002751-0000-1000-8000-00805f9b34fb", "molar energy (joule per mole)");
        attributes.put("00002752-0000-1000-8000-00805f9b34fb", "molar entropy (joule per mole kelvin)");
        attributes.put("00002753-0000-1000-8000-00805f9b34fb", "exposure (coulomb per kilogram)");
        attributes.put("00002754-0000-1000-8000-00805f9b34fb", "absorbed dose rate (gray per second)");
        attributes.put("00002755-0000-1000-8000-00805f9b34fb", "radiant intensity (watt per steradian)");
        attributes.put("00002756-0000-1000-8000-00805f9b34fb", "radiance (watt per square metre steradian)");
        attributes.put("00002757-0000-1000-8000-00805f9b34fb", "catalytic activity concentration (katal per cubic metre)");
        attributes.put("00002760-0000-1000-8000-00805f9b34fb", "time (minute)");
        attributes.put("00002761-0000-1000-8000-00805f9b34fb", "time (hour)");
        attributes.put("00002762-0000-1000-8000-00805f9b34fb", "time (day)");
        attributes.put("00002763-0000-1000-8000-00805f9b34fb", "plane angle (degree)");
        attributes.put("00002764-0000-1000-8000-00805f9b34fb", "plane angle (minute)");
        attributes.put("00002765-0000-1000-8000-00805f9b34fb", "plane angle (second)");
        attributes.put("00002766-0000-1000-8000-00805f9b34fb", "area (hectare)");
        attributes.put("00002767-0000-1000-8000-00805f9b34fb", "volume (litre)");
        attributes.put("00002768-0000-1000-8000-00805f9b34fb", "mass (tonne)");
        attributes.put("00002780-0000-1000-8000-00805f9b34fb", "pressure (bar)");
        attributes.put("00002781-0000-1000-8000-00805f9b34fb", "pressure (millimetre of mercury)");
        attributes.put("00002782-0000-1000-8000-00805f9b34fb", "length (angstrom)");
        attributes.put("00002783-0000-1000-8000-00805f9b34fb", "length (nautical mile)");
        attributes.put("00002784-0000-1000-8000-00805f9b34fb", "area (barn)");
        attributes.put("00002785-0000-1000-8000-00805f9b34fb", "velocity (knot)");
        attributes.put("00002786-0000-1000-8000-00805f9b34fb", "logarithmic radio quantity (neper)");
        attributes.put("00002787-0000-1000-8000-00805f9b34fb", "logarithmic radio quantity (bel)");
        attributes.put("000027a0-0000-1000-8000-00805f9b34fb", "length (yard)");
        attributes.put("000027a1-0000-1000-8000-00805f9b34fb", "length (parsec)");
        attributes.put("000027a2-0000-1000-8000-00805f9b34fb", "length (inch)");
        attributes.put("000027a3-0000-1000-8000-00805f9b34fb", "length (foot)");
        attributes.put("000027a4-0000-1000-8000-00805f9b34fb", "length (mile)");
        attributes.put("000027a5-0000-1000-8000-00805f9b34fb", "pressure (pound-force per square inch)");
        attributes.put("000027a6-0000-1000-8000-00805f9b34fb", "velocity (kilometre per hour)");
        attributes.put("000027a7-0000-1000-8000-00805f9b34fb", "velocity (mile per hour)");
        attributes.put("000027a8-0000-1000-8000-00805f9b34fb", "angular velocity (revolution per minute)");
        attributes.put("000027a9-0000-1000-8000-00805f9b34fb", "energy (gram calorie)");
        attributes.put("000027aa-0000-1000-8000-00805f9b34fb", "energy (kilogram calorie)");
        attributes.put("000027ab-0000-1000-8000-00805f9b34fb", "energy (kilowatt hour)");
        attributes.put("000027ac-0000-1000-8000-00805f9b34fb", "thermodynamic temperature (degree Fahrenheit)");
        attributes.put("000027ad-0000-1000-8000-00805f9b34fb", "percentage");
        attributes.put("000027ae-0000-1000-8000-00805f9b34fb", "per mille");
        attributes.put("000027af-0000-1000-8000-00805f9b34fb", "period (beats per minute)");
        attributes.put("000027b0-0000-1000-8000-00805f9b34fb", "electric charge (ampere hours)");
        attributes.put("000027b1-0000-1000-8000-00805f9b34fb", "mass density (milligram per decilitre)");
        attributes.put("000027b2-0000-1000-8000-00805f9b34fb", "mass density (millimole per litre)");
        attributes.put("000027b3-0000-1000-8000-00805f9b34fb", "time (year)");
        attributes.put("000027b4-0000-1000-8000-00805f9b34fb", "time (month)");
        attributes.put("000027b5-0000-1000-8000-00805f9b34fb", "concentration (count per cubic metre)");
        attributes.put("000027b6-0000-1000-8000-00805f9b34fb", "irradiance (watt per square metre)");
        attributes.put("000027b7-0000-1000-8000-00805f9b34fb", "milliliter (per kilogram per minute)");
        attributes.put("000027b8-0000-1000-8000-00805f9b34fb", "mass (pound)");
        attributes.put("00002800-0000-1000-8000-00805f9b34fb", "GATT Primary Service Declaration");
        attributes.put("00002801-0000-1000-8000-00805f9b34fb", "GATT Secondary Service Declaration");
        attributes.put("00002802-0000-1000-8000-00805f9b34fb", "GATT Include Declaration");
        attributes.put("00002803-0000-1000-8000-00805f9b34fb", "GATT Characteristic Declaration");
        attributes.put("00002900-0000-1000-8000-00805f9b34fb", "Characteristic Extended Properties");
        attributes.put("00002901-0000-1000-8000-00805f9b34fb", "Characteristic User Description");
        attributes.put("00002902-0000-1000-8000-00805f9b34fb", "Client Characteristic Configuration");
        attributes.put("00002903-0000-1000-8000-00805f9b34fb", "Server Characteristic Configuration");
        attributes.put("00002904-0000-1000-8000-00805f9b34fb", "Characteristic Presentation Format");
        attributes.put("00002905-0000-1000-8000-00805f9b34fb", "Characteristic Aggregate Format");
        attributes.put("00002906-0000-1000-8000-00805f9b34fb", "Valid Range");
        attributes.put("00002907-0000-1000-8000-00805f9b34fb", "External Report Reference");
        attributes.put("00002908-0000-1000-8000-00805f9b34fb", "Report Reference");
        attributes.put("00002909-0000-1000-8000-00805f9b34fb", "Number of Digits");
        attributes.put("0000290a-0000-1000-8000-00805f9b34fb", "Trigger Setting");
        attributes.put("0000290b-0000-1000-8000-00805f9b34fb", "Environmental Sensing Configuration");
        attributes.put("0000290c-0000-1000-8000-00805f9b34fb", "Environmental Sensing Measurement");
        attributes.put("0000290d-0000-1000-8000-00805f9b34fb", "Environmental Sensing Trigger Setting");
        attributes.put("00002a00-0000-1000-8000-00805f9b34fb", "Device Name");
        attributes.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");
        attributes.put("00002a02-0000-1000-8000-00805f9b34fb", "Peripheral Privacy Flag");
        attributes.put("00002a03-0000-1000-8000-00805f9b34fb", "Reconnection Address");
        attributes.put("00002a04-0000-1000-8000-00805f9b34fb", "Peripheral Preferred Connection Parameters");
        attributes.put("00002a05-0000-1000-8000-00805f9b34fb", "Service Changed");
        attributes.put("00002a06-0000-1000-8000-00805f9b34fb", "Alert Level");
        attributes.put("00002a07-0000-1000-8000-00805f9b34fb", "Tx Power Level");
        attributes.put("00002a08-0000-1000-8000-00805f9b34fb", "Date Time");
        attributes.put("00002a09-0000-1000-8000-00805f9b34fb", "Day of Week");
        attributes.put("00002a0a-0000-1000-8000-00805f9b34fb", "Day Date Time");
        attributes.put("00002a0b-0000-1000-8000-00805f9b34fb", "Exact Time 100");
        attributes.put("00002a0c-0000-1000-8000-00805f9b34fb", "Exact Time 256");
        attributes.put("00002a0d-0000-1000-8000-00805f9b34fb", "DST Offset");
        attributes.put("00002a0e-0000-1000-8000-00805f9b34fb", "Time Zone");
        attributes.put("00002a0f-0000-1000-8000-00805f9b34fb", "Local Time Information");
        attributes.put("00002a10-0000-1000-8000-00805f9b34fb", "Secondary Time Zone");
        attributes.put("00002a11-0000-1000-8000-00805f9b34fb", "Time with DST");
        attributes.put("00002a12-0000-1000-8000-00805f9b34fb", "Time Accuracy");
        attributes.put("00002a13-0000-1000-8000-00805f9b34fb", "Time Source");
        attributes.put("00002a14-0000-1000-8000-00805f9b34fb", "Reference Time Information");
        attributes.put("00002a15-0000-1000-8000-00805f9b34fb", "Time Broadcast");
        attributes.put("00002a16-0000-1000-8000-00805f9b34fb", "Time Update Control Point");
        attributes.put("00002a17-0000-1000-8000-00805f9b34fb", "Time Update State");
        attributes.put("00002a18-0000-1000-8000-00805f9b34fb", "Glucose Measurement");
        attributes.put("00002a19-0000-1000-8000-00805f9b34fb", "Battery Level");
        attributes.put("00002a1a-0000-1000-8000-00805f9b34fb", "Battery Power State");
        attributes.put("00002a1b-0000-1000-8000-00805f9b34fb", "Battery Level State");
        attributes.put("00002a1c-0000-1000-8000-00805f9b34fb", "Temperature Measurement");
        attributes.put("00002a1d-0000-1000-8000-00805f9b34fb", "Temperature Type");
        attributes.put("00002a1e-0000-1000-8000-00805f9b34fb", "Intermediate Temperature");
        attributes.put("00002a1f-0000-1000-8000-00805f9b34fb", "Temperature Celsius");
        attributes.put("00002a20-0000-1000-8000-00805f9b34fb", "Temperature Fahrenheit");
        attributes.put("00002a21-0000-1000-8000-00805f9b34fb", "Measurement Interval");
        attributes.put("00002a22-0000-1000-8000-00805f9b34fb", "Boot Keyboard Input Report");
        attributes.put("00002a23-0000-1000-8000-00805f9b34fb", "System ID");
        attributes.put("00002a24-0000-1000-8000-00805f9b34fb", "Model Number String");
        attributes.put("00002a25-0000-1000-8000-00805f9b34fb", "Serial Number String" );
        attributes.put("00002a26-0000-1000-8000-00805f9b34fb", "Firmware Revision String");
        attributes.put("00002a27-0000-1000-8000-00805f9b34fb", "Hardware Revision String");
        attributes.put("00002a28-0000-1000-8000-00805f9b34fb", "Software Revision String");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
        attributes.put("00002a2a-0000-1000-8000-00805f9b34fb", "IEEE 11073-20601 Regulatory Certification Data List");
        attributes.put("00002a2b-0000-1000-8000-00805f9b34fb", "Current Time");
        attributes.put("00002a2c-0000-1000-8000-00805f9b34fb", "Elevation");
        attributes.put("00002a2d-0000-1000-8000-00805f9b34fb", "Latitude");
        attributes.put("00002a2e-0000-1000-8000-00805f9b34fb", "Longitude");
        attributes.put("00002a2f-0000-1000-8000-00805f9b34fb", "Position 2D");
        attributes.put("00002a30-0000-1000-8000-00805f9b34fb", "Position 3D");
        attributes.put("00002a31-0000-1000-8000-00805f9b34fb", "Scan Refresh");
        attributes.put("00002a32-0000-1000-8000-00805f9b34fb", "Boot Keyboard Output Report");
        attributes.put("00002a33-0000-1000-8000-00805f9b34fb", "Boot Mouse Input Report");
        attributes.put("00002a34-0000-1000-8000-00805f9b34fb", "Glucose Measurement Context");
        attributes.put("00002a35-0000-1000-8000-00805f9b34fb", "Blood Pressure Measurement");
        attributes.put("00002a36-0000-1000-8000-00805f9b34fb", "Intermediate Cuff Pressure");
        attributes.put("00002a37-0000-1000-8000-00805f9b34fb", "Heart Rate Measurement");
        attributes.put("00002a38-0000-1000-8000-00805f9b34fb", "Body Sensor Location");
        attributes.put("00002a39-0000-1000-8000-00805f9b34fb", "Heart Rate Control Point");
        attributes.put("00002a3a-0000-1000-8000-00805f9b34fb", "Removable");
        attributes.put("00002a3b-0000-1000-8000-00805f9b34fb", "Service Required");
        attributes.put("00002a3c-0000-1000-8000-00805f9b34fb", "Scientific Temperature Celsius");
        attributes.put("00002a3d-0000-1000-8000-00805f9b34fb", "String");
        attributes.put("00002a3e-0000-1000-8000-00805f9b34fb", "Network Availability");
        attributes.put("00002a3f-0000-1000-8000-00805f9b34fb", "Alert Status");
        attributes.put("00002a40-0000-1000-8000-00805f9b34fb", "Ringer Control Point");
        attributes.put("00002a41-0000-1000-8000-00805f9b34fb", "Ringer Setting");
        attributes.put("00002a42-0000-1000-8000-00805f9b34fb", "Alert Category ID Bit Mask");
        attributes.put("00002a43-0000-1000-8000-00805f9b34fb", "Alert Category ID");
        attributes.put("00002a44-0000-1000-8000-00805f9b34fb", "Alert Notification Control Point");
        attributes.put("00002a45-0000-1000-8000-00805f9b34fb", "Unread Alert Status");
        attributes.put("00002a46-0000-1000-8000-00805f9b34fb", "New Alert");
        attributes.put("00002a47-0000-1000-8000-00805f9b34fb", "Supported New Alert Category");
        attributes.put("00002a48-0000-1000-8000-00805f9b34fb", "Supported Unread Alert Category");
        attributes.put("00002a49-0000-1000-8000-00805f9b34fb", "Blood Pressure Feature");
        attributes.put("00002a4a-0000-1000-8000-00805f9b34fb", "HID Information");
        attributes.put("00002a4b-0000-1000-8000-00805f9b34fb", "HID Report Map");
        attributes.put("00002a4c-0000-1000-8000-00805f9b34fb", "HID Control Point");
        attributes.put("00002a4e-0000-1000-8000-00805f9b34fb", "Protocol Mode");
        attributes.put("00002a4f-0000-1000-8000-00805f9b34fb", "Scan Interval Windows");
        attributes.put("00002a50-0000-1000-8000-00805f9b34fb", "PnP ID");
        attributes.put("00002a51-0000-1000-8000-00805f9b34fb", "Glucose Feature");
        attributes.put("00002a52-0000-1000-8000-00805f9b34fb", "Glucose RACP");
        attributes.put("00002a53-0000-1000-8000-00805f9b34fb", "RSC Measurement");
        attributes.put("00002a54-0000-1000-8000-00805f9b34fb", "RSC Feature");
        attributes.put("00002a55-0000-1000-8000-00805f9b34fb", "RSC/CSC Control Point");
        attributes.put("00002a56-0000-1000-8000-00805f9b34fb", "Digital Input");
        attributes.put("00002a57-0000-1000-8000-00805f9b34fb", "Digital Output");
        attributes.put("00002a58-0000-1000-8000-00805f9b34fb", "Analog Input");
        attributes.put("00002a59-0000-1000-8000-00805f9b34fb", "Analog Output");
        attributes.put("00002a5A-0000-1000-8000-00805f9b34fb", "Aggregate Input");
        attributes.put("00002a5b-0000-1000-8000-00805f9b34fb", "CSC Measurement");
        attributes.put("00002a5c-0000-1000-8000-00805f9b34fb", "CSC Feature");
        attributes.put("00002a5d-0000-1000-8000-00805f9b34fb", "Sensor Location");
        attributes.put("00002a5f-0000-1000-8000-00805f9b34fb", "Oximetry Continuous Measure Temp");
        attributes.put("00002a60-0000-1000-8000-00805f9b34fb", "Oximetry Pulsatile Event Temp");
        attributes.put("00002a61-0000-1000-8000-00805f9b34fb", "Oximetry Feature Temp");
        attributes.put("00002a62-0000-1000-8000-00805f9b34fb", "Oximetry Control Point Temp");
        attributes.put("00002a63-0000-1000-8000-00805f9b34fb", "Cycling Power Measurement");
        attributes.put("00002a64-0000-1000-8000-00805f9b34fb", "Cycling Power Vector");
        attributes.put("00002a65-0000-1000-8000-00805f9b34fb", "Cycling Power Feature");
        attributes.put("00002a66-0000-1000-8000-00805f9b34fb", "Cycling Power Control Point");
        attributes.put("00002a67-0000-1000-8000-00805f9b34fb", "Location and Speed");
        attributes.put("00002a68-0000-1000-8000-00805f9b34fb", "Navigation");
        attributes.put("00002a69-0000-1000-8000-00805f9b34fb", "Position Quality");
        attributes.put("00002a6a-0000-1000-8000-00805f9b34fb", "LN Feature");
        attributes.put("00002a6b-0000-1000-8000-00805f9b34fb", "LN Control Point");
        attributes.put("00002a6c-0000-1000-8000-00805f9b34fb", "Elevation");
        attributes.put("00002a6d-0000-1000-8000-00805f9b34fb", "Pressure");
        attributes.put("00002a6f-0000-1000-8000-00805f9b34fb", "Humidity");
        attributes.put("00002a72-0000-1000-8000-00805f9b34fb", "Apparent Wind Speed");
        attributes.put("00002a73-0000-1000-8000-00805f9b34fb", "Apparent Wind Direction?");
        attributes.put("00002a74-0000-1000-8000-00805f9b34fb", "Gust Factor");
        attributes.put("00002a75-0000-1000-8000-00805f9b34fb", "Pollen Concentration");
        attributes.put("00002a77-0000-1000-8000-00805f9b34fb", "Irradiance");
        attributes.put("00002a7a-0000-1000-8000-00805f9b34fb", "Heat Index");
        attributes.put("00002a7b-0000-1000-8000-00805f9b34fb", "Dew Point");
        attributes.put("00002a7d-0000-1000-8000-00805f9b34fb", "Descriptor Value Changed");
        attributes.put("00002a7e-0000-1000-8000-00805f9b34fb", "Aerobic Heart Rate Lower Limit");
        attributes.put("00002a7f-0000-1000-8000-00805f9b34fb", "Aerobic Threshold");
        attributes.put("00002a80-0000-1000-8000-00805f9b34fb", "Age");
        attributes.put("00002a81-0000-1000-8000-00805f9b34fb", "Anaerobic Heart Rate Lower Limit");
        attributes.put("00002a82-0000-1000-8000-00805f9b34fb", "Anaerobic Heart Rate Upper Limit");
        attributes.put("00002a83-0000-1000-8000-00805f9b34fb", "Anaerobic Threshold");
        attributes.put("00002a84-0000-1000-8000-00805f9b34fb", "Aerobic Heart Rate Upper Limit");
        attributes.put("00002a85-0000-1000-8000-00805f9b34fb", "Date of Birth");
        attributes.put("00002a86-0000-1000-8000-00805f9b34fb", "Date of Threshold Assessment");
        attributes.put("00002a87-0000-1000-8000-00805f9b34fb", "Email Address");
        attributes.put("00002a88-0000-1000-8000-00805f9b34fb", "Fat Burn Heart Rate Lower Limit");
        attributes.put("00002a89-0000-1000-8000-00805f9b34fb", "Fat Burn Heart Rate Upper Limit");
        attributes.put("00002a8a-0000-1000-8000-00805f9b34fb", "First Name");
        attributes.put("00002a8b-0000-1000-8000-00805f9b34fb", "Five Zone Heart Rate Limits");
        attributes.put("00002a8c-0000-1000-8000-00805f9b34fb", "Gender");
        attributes.put("00002a8d-0000-1000-8000-00805f9b34fb", "Heart Rate Max");
        attributes.put("00002a8e-0000-1000-8000-00805f9b34fb", "Height");
        attributes.put("00002a8f-0000-1000-8000-00805f9b34fb", "Hip Circumference");
        attributes.put("00002a90-0000-1000-8000-00805f9b34fb", "Last Name");
        attributes.put("00002a91-0000-1000-8000-00805f9b34fb", "Maximum Recommended Heart Rate");
        attributes.put("00002a99-0000-1000-8000-00805f9b34fb", "Database Change Increment");
        attributes.put("00002a9b-0000-1000-8000-00805f9b34fb", "Body Composition Feature");
        attributes.put("00002a9c-0000-1000-8000-00805f9b34fb", "Body Composition Measurement");
        attributes.put("00002aa0-0000-1000-8000-00805f9b34fb", "Magnetic Flux Density - 2D");
        attributes.put("00002aa1-0000-1000-8000-00805f9b34fb", "Magnetic Flux Density - 3D");
        attributes.put("00002aa2-0000-1000-8000-00805f9b34fb", "Language");
        attributes.put("00002aa3-0000-1000-8000-00805f9b34fb", "Barometric Pressure Trend");
        attributes.put("00002aa4-0000-1000-8000-00805f9b34fb", "Bond Management Control Point");
        attributes.put("00002aa5-0000-1000-8000-00805f9b34fb", "Bond Management Feature");
        attributes.put("00002aa6-0000-1000-8000-00805f9b34fb", "Central Address Resolution");
        attributes.put("00002aa7-0000-1000-8000-00805f9b34fb", "CGM Measurement");
        attributes.put("00002aa8-0000-1000-8000-00805f9b34fb", "CGM Feature");
        attributes.put("00002aa9-0000-1000-8000-00805f9b34fb", "CGM Status");
        attributes.put("00002aaa-0000-1000-8000-00805f9b34fb", "CGM Session Start Time");
        attributes.put("00002aab-0000-1000-8000-00805f9b34fb", "CGM Session Run Time");
        attributes.put("00002aac-0000-1000-8000-00805f9b34fb", "CGM Specific Ops Control Point");

        attributes.put("0000b000-0000-1000-8000-00805f9b34fb", "Weight Scale");
        attributes.put("0000b001-0000-1000-8000-00805f9b34fb", "Weight Scale Measurement");
        attributes.put("0000c000-0000-1000-8000-00805f9b34fb", "Continuout Gluecose Measurement");
        attributes.put("0000c001-0000-1000-8000-00805f9b34fb", "Continuous Glucose Measurement");
        attributes.put("0000c002-0000-1000-8000-00805f9b34fb", "Continuous Glucose Features");
        attributes.put("0000c003-0000-1000-8000-00805f9b34fb", "Continuous Glucose Status");
        attributes.put("0000c004-0000-1000-8000-00805f9b34fb", "Continuous Glucose Session");
        attributes.put("0000c005-0000-1000-8000-00805f9b34fb", "Continuous Glucose Runtime");
        attributes.put("0000c006-0000-1000-8000-00805f9b34fb", "Continuous Glucose RACP");
        attributes.put("0000c007-0000-1000-8000-00805f9b34fb", "Continuous Glucose ASCP");
        attributes.put("0000c008-0000-1000-8000-00805f9b34fb", "Continuous Glucose CGMCP");
        attributes.put("0000d000-0000-1000-8000-00805f9b34fb", "Pedometer");
        attributes.put("0000d001-0000-1000-8000-00805f9b34fb", "Pedometer Measurement");
        attributes.put("0000e000-0000-1000-8000-00805f9b34fb", "Audio Temp");
        attributes.put("0000e001-0000-1000-8000-00805f9b34fb", "Audio Battery Level Temp");
        attributes.put("0000e002-0000-1000-8000-00805f9b34fb", "Audio LeftRight Temp");
        attributes.put("0000e003-0000-1000-8000-00805f9b34fb", "Audio Hi ID Temp");
        attributes.put("0000e004-0000-1000-8000-00805f9b34fb", "Audio Other Hi ID Temp");
        attributes.put("0000e005-0000-1000-8000-00805f9b34fb", "Audio Mic Attenuation Temp");
        attributes.put("0000e006-0000-1000-8000-00805f9b34fb", "Audio 2nd Stream Attenuation Temp");
        attributes.put("0000e007-0000-1000-8000-00805f9b34fb", "Audio Available Programs Bitmap Temp");
        attributes.put("0000e008-0000-1000-8000-00805f9b34fb", "Audio Stream Programs Bitmap Temp");
        attributes.put("0000e009-0000-1000-8000-00805f9b34fb", "Audio Current Active Program Temp");
        attributes.put("0000e00a-0000-1000-8000-00805f9b34fb", "Audio Program Data Version Temp");
        attributes.put("0000e00b-0000-1000-8000-00805f9b34fb", "Audio Program ID Name Selector Temp");
        attributes.put("0000e00c-0000-1000-8000-00805f9b34fb", "Audio Program Name Temp");
        attributes.put("0000e00d-0000-1000-8000-00805f9b34fb", "Audio Program Catogory Temp");

        // Non-Standard public, ordered by UUID -------------------------------------------------------------------------------------------------------

        attributes.put("0000ffe0-0000-1000-8000-00805f9b34fb", "HM-10 UART Service");
        attributes.put("0000ffe1-0000-1000-8000-00805f9b34fb", "HM-10 UART RX/TX");

        //Posture Sensing Service
        attributes.put("0000ffe0-0000-1000-8000-00805f9b34fb", "Posture Sensing Service"); //collision with HM-10
        attributes.put("0000ffe5-0000-1000-8000-00805f9b34fb", "Control Service");
        attributes.put("0000ffe9-0000-1000-8000-00805f9b34fb", "UART TX");

        attributes.put("0000fff0-0000-1000-8000-00805f9b34fb", "ISSC Transparent Service");
        attributes.put("0000fff1-0000-1000-8000-00805f9b34fb", "ISSC Transparent RX");
        attributes.put("0000fff2-0000-1000-8000-00805f9b34fb", "ISSC Transparent TX");


        attributes.put("0000fff6-0000-1000-8000-00805f9b34fb", "RX");
        attributes.put("0000fff7-0000-1000-8000-00805f9b34fb", "TX");

        //Nodric Service
        attributes.put("6e400001-b5a3-f393-e0a9-e50e24dcca9e", "Nodric UART Service");
        attributes.put("6e400002-b5a3-f393-e0a9-e50e24dcca9e", "Nodric UART Rx Char");
        attributes.put("6e400003-b5a3-f393-e0a9-e50e24dcca9e", "Nodric UART Tx Char");
        attributes.put("00001530-1212-efde-1523-785feabcd123", "Nodric DFU Service");
        attributes.put("00001531-1212-efde-1523-785feabcd123", "Nodric DFU Control Point");
        attributes.put("00001532-1212-efde-1523-785feabcd123", "Nodric DFU Packet");

        //Read Bear
        attributes.put("713d0000-503e-4c75-ba94-3148f18d941e", "RedBearLab Service");
        attributes.put("713d0002-503e-4c75-ba94-3148f18d941e", "RedBearLab RX Service");
        attributes.put("713d0003-503e-4c75-ba94-3148f18d941e", "RedBearLab TX Service");

        // RedBear Beacon B1
        attributes.put("b0702881-a295-a8ab-f734-031a98a512d", "RedBear B1 iBeacon");
        attributes.put("b0702882-a295-a8ab-f734-031a98a512d", "RedBear B1 Major ID");
        attributes.put("b0702883-a295-a8ab-f734-031a98a512d", "RedBear B1 Minor ID");
        attributes.put("b0702884-a295-a8ab-f734-031a98a512d", "RedBear B1 Measured Power");
        attributes.put("b0702885-a295-a8ab-f734-031a98a512d", "RedBear B1 LED Switch ");
        attributes.put("b0702886-a295-a8ab-f734-031a98a512d", "RedBear B1 Advertising Interval");
        attributes.put("b0702887-a295-a8ab-f734-031a98a512d", "RedBear B1 Output Power");
        attributes.put("b0702888-a295-a8ab-f734-031a98a512d", "RedBear B1 Firmware Version");

        //ISSC dual mode
        attributes.put("49535343-fe7d-4ae5-8fa9-9fafd205e455", "ISSC Proprietary Service");
        attributes.put("49535343-1e4d-4bd9-ba61-23c647249616", "ISSC Transparent TX");
        attributes.put("49535343-8841-43f4-a8d4-ecbe34729bb3", "ISSC Transparent RX");
        attributes.put("49535343-6daa-4d02-abf6-19569aca69fe", "ISSC Update Connection Parameter");
        attributes.put("49535343-6daa-4d02-abf6-19569aca69fe", "ISSC Update Connection Parameter");
        attributes.put("49535343-aca3-481c-91ec-d85e28a60318", "ISSC Air Patch");

        //Stollmann Terminal IO
        attributes.put("0000fefb-0000-1000-8000-00805f9b34fb", "Stollmann Terminal IO Service");
        attributes.put("00000001-0000-1000-8000-008025000000", "Stollmann UART RX");
        attributes.put("00000002-0000-1000-8000-008025000000", "Stollmann UART TX");
        attributes.put("00000004-0000-1000-8000-008025000000", "Stollmann Credits UART RX");

        //Apple Notification Center Service
        attributes.put("7905f431-b5ce-4e99-a40f-4b1e122d00d0", "Apple Notification Center Service");
        attributes.put("9fbf120d-6301-42d9-8c58-25e699a21dbd", "Notification Source");
        attributes.put("69d1d8f3-45e1-49a8-9821-9bbdfdaad9d9", "Control Point UUID");
        attributes.put("22eac6e9-24d6-4bb5-be44-b36ace7c7bfb", "Data Source");

        //Laird BL600 Virtual Serial Port Service
        attributes.put("569a1101-b87f-490c-92cb-11ba5ea5167c", "BL600 vSP Service");
        attributes.put("569a2000-b87f-490c-92cb-11ba5ea5167c", "TX FIFO");
        attributes.put("569a2001-b87f-490c-92cb-11ba5ea5167c", "RX FIFO");
        attributes.put("569a2002-b87f-490c-92cb-11ba5ea5167c", "Modem Out");
        attributes.put("569a2003-b87f-490c-92cb-11ba5ea5167c", "Modem In");
    }
}
