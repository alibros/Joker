/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package uk.co.alibros.myapplication.backend;

import com.alibros.Supplier;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.alibros.co.uk",
                ownerName = "backend.myapplication.alibros.co.uk",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getjoke")
    public JokeBean getjoke() {
        JokeBean response = new JokeBean();
        Supplier supplier = new Supplier();
        String joke = supplier.getRandomJoke();
        response.setData(joke);
        return response;
    }

}
