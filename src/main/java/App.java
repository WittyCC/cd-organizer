import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("CDs", request.session().attribute("CDs"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("CDs/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/CD-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/CDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("CDs", CD.all());
      model.put("template", "templates/CDs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Artist artist = Artist.find(Integer.parseInt(request.queryParams("artistId")));

      String name = request.queryParams("name");
      String musicType = request.queryParams("musicType");
      CD newCD = new CD(name, musicType);

      artist.addCD(newCD);

      model.put("artist", artist);
      model.put("template", "templates/artist-CDs-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Artist newArtist = new Artist(name);
      model.put("template", "templates/artist-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("artists", Artist.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("artists/:id/CDs/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);
      model.put("template", "templates/artist-CDs-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
