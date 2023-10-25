import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private TextView latitudeTextView;
    private TextView longitudeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeTextView.setText(String.valueOf(location.getLatitude()));
        longitudeTextView.setText(String.valueOf(location.getLongitude()));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Não é necessário
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Não é necessário
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Não é necessário
    }
}
