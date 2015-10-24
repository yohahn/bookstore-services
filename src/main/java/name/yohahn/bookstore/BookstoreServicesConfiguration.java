package name.yohahn.bookstore;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by yohahn.kim on 10/23/15.
 */
public class BookstoreServicesConfiguration extends Configuration {

    @Valid
    @NotNull
    public DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    public KatharsisConfiguration katharsis = new KatharsisConfiguration();

    public class KatharsisConfiguration {
        @Valid
        @NotNull
        public String host;

        @Valid
        @NotNull
        public String searchPackage;
    }
}
