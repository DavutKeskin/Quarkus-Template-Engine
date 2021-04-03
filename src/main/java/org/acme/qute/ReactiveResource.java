package org.acme.qute;

import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ReactiveResource {

    @Inject
    SampleService service;

    @ResourcePath("reports/v1/report_01.json.template")
    Template report;

    @Route(path = "/reactive", methods = HttpMethod.GET, produces = MediaType.APPLICATION_JSON)
    void reactive(RoutingExchange ex) throws Exception {
        report
          .data("samples",service.get())
          .data("now", java.time.LocalDateTime.now())
          .renderAsync()
          .thenAccept((val) -> ex.ok(val));
    }
}
