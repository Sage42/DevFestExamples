package org.sage42.devfest.c.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.sage42.devfest.c.main.CombinedData;
import org.sage42.devfest.c.main.Event;

import com.google.gson.Gson;

@SuppressWarnings("nls")
public class GsonParsingTest
{
    private static String JSON;

    static
    {
        final StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"events\": [");
        json.append("{");
        json.append("  \"text\": \"Interdumdonec ipsum ut inceptos varius tempus sempermorbi, clita esse ipsuminteger fusce sem consetetur montes nisi. Quis primis dictumstvivamus semper nullamauris magnainteger. Ipsuminteger lobortisetiam, mi labore at et dictumst. Conubia elitduis ad blandit nullasuspendisse. Kasd sadipscing pretium id tortorvestibulum, platea in parturient morbi luctus sodalessed urnamorbi. Proin fringilla. Odio class.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Deirdre Zaira Liza Ross\",");
        json.append("  \"link\": \"http://domain.com/darrel/megan/angelica/craig\",");
        json.append("  \"resource_uri\": \"/api/v1/event/1/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Gubergren doming consequatduis lobortisetiam. Faucibusvestibulum ullamcorper. Aliquet venenatis dolore fermentum vel facilisi, eos massaphasellus sed mollis potenti torquent neque. Ornare aliquam. Iusto adipiscing dis, tempus at neque sodales. Habitasse nullasuspendisse semvestibulum. Risusdonec semper soluta, nonumy aliquet suspendisse dolores sapien nec. Nullasuspendisse justo doming ultricies, augue consectetuer pretium habitant morbi. At nostrud temporsuspendisse euismod te metus erat, lobortis ea nequeetiam convallis vero egestas montes. Quisque consetetur tincidunt, suscipit at dictumstvivamus cursus accusam vero ultriciespellentesque risusdonec.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Gerry Jesse\",");
        json.append("  \"link\": \"http://domain.com/sidney/cary\",");
        json.append("  \"resource_uri\": \"/api/v1/event/2/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Neque nonummy minim egestas congue enimsed, purus dictum natoque elitduis gubergren bibendumfusce eos nunc. Rutrum ullamcorper dictum gravida, rhoncusmaecenas dictumstvivamus purus augue. Vestibulum elitnunc volutpat eirmod feugiat antesuspendisse mus, nec sit senectus pulvinar ad gravida ipsum justo. Nibh temporsuspendisse proin. Sanctus risus. Integer sanctus ut, variuscras nobis possim sapien. Delenit invidunt tortor antesuspendisse te, urnamorbi potenti conubia lorem labore metus possim curae dui urna. Cum iriure pulvinarvestibulum sapien, lectus habitasse purus conubia clita. Conubia lectusnullam eirmod, facilisisproin netus duimauris bibendum te. Platea taciti minulla pellentesque conubia, sociis invidunt duo minim telluspraesent. Sagittis justocras, lacusut ad posuere class option. Praesent fermentum feliscras facilisi nascetur sempermorbi, nunccurabitur elementum exerci diam. Dolor eros urnamorbi eos antesuspendisse, semper risusdonec ex volutpatut metus tempor convallis iusto felissed. Cursus adipiscing faucibus dapibusnam congue, dolores accusam iaculis tristique feugait facilisi elementum soluta.\",");
        json.append("  \"image\": null,");
        json.append("  \"title\": \"Deandre Tyson Jeremiah\",");
        json.append("  \"link\": \"http://domain.com/noah/oliver/marcia/karla/edith\",");
        json.append("  \"resource_uri\": \"/api/v1/event/3/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Inceptos accusam facilisicurabitur sapien tation, aliquyam gubergren urnapraesent phasellus platea luptatum augue vulputate sempermorbi malesuadanullam. Tortorcurabitur auctormauris, rutrum habitant ligula sanctus enimaliquam. Consequat aaenean te tincidunt, cum dignissim feugait senectus conubia kasd soluta. Elitduis nullam egestas. A id accumsannulla lectus metus aptent, semvestibulum delenit magnapraesent luctus volutpat.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Tanner Alfie Hanna\",");
        json.append("  \"link\": \"http://domain.com/amari/pam/clarissa\",");
        json.append("  \"resource_uri\": \"/api/v1/event/4/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Aliquam lobortisetiam nullasuspendisse varius ex, tempor auctormauris lectusnullam sanctus pretium nullamauris. Elit odio mattis. Quisque lorem maurisaenean metus tellus nunc, sedfusce autem volutpatut iaculis nihil. Facilisinam sit enimsed, tortorvestibulum vivamus faucibusvestibulum nequeetiam. Senectus proin viverra elit te, aliquam telluspraesent rebum.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Elmer Bryon Bridgette Dick Christine\",");
        json.append("  \"link\": \"http://domain.com/earnest/randall/alexandria/will/itzel\",");
        json.append("  \"resource_uri\": \"/api/v1/event/5/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Porta iusto consectetuer eget lobortisetiam at, fusce invidunt sea ornare nihil senectus. Risus ante nobis. Risusdonec nullasuspendisse dui tincidunt nascetur rutrum. Orci temporsuspendisse inceptos accumsan viverra, vel facilisis variuscras dapibusnam ornare pretium ipsumcurabitur minulla netus. Assum cras hendrerit congue convallis. Duo inceptos cras lobortisetiam. Soluta rhoncus sagittis urnapraesent imperdiet dictum. Sapien consecteturpraesent facilisis lectus exerci. Auctor interdumdonec massa arcu tincidunt accusam, lobortis mi purusvestibulum praesent. Sed primis imperdiet temporsuspendisse.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Solomon\",");
        json.append("  \"link\": \"http://domain.com/vihan\",");
        json.append("  \"resource_uri\": \"/api/v1/event/6/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Iusto consetetur arcumorbi enimaliquam id, nihil nascetur placerat ut pulvinarvestibulum. Turpis maecenas. Libero morbi arcu magnapraesent facilisisat pharetra vivamus, leopraesent consetetur delenit lacusut ultriciespellentesque iaculis lobortisetiam. Tation elitduis. Nulla posuere veniam. No bibendumfusce dolore lacusnulla himenaeos minulla, tempus bibendumin vestibulum porttitor diaminteger magnapraesent elementum. Elitvivamus ultrices arcumorbi nullasuspendisse natoque elementum, interdumdonec fermentum leo sit luptatum enimsed. Nonummy suspendisse. Tortor conguenulla per platea fringilla kasd nisl, wisi nullasuspendisse odio muspellentesque lobortis ametduis nisi aliquet. Dolore feliscras habitant a. Blandit bibendumin. Cubilia dis dapibus volutpat velit. Magnainteger labore clita diaminteger, soluta augue tation sanctus.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Giselle Danette Ava Alanna\",");
        json.append("  \"link\": \"http://domain.com/craig/georgia/terrence/kasey/jarrett\",");
        json.append("  \"resource_uri\": \"/api/v1/event/7/\"");
        json.append("},");
        json.append("{");
        json.append("  \"text\": \"Montes potenti orci voluptua, dignissim inceptos massa variuscras minim nondonec nam. Erat maecenas nonummy a purus imperdiet. Quammaecenas dolor porttitor faucibus ipsumcurabitur purusvestibulum eum cubilia, te leopraesent fringilla pretium duis vel. Enimaliquam minulla vestibulumnulla, imperdietaliquam nobis possim iaculis magnainteger condimentum. Aliquammauris purusvestibulum lobortisetiam. Dictum auctormauris ligula mipellentesque nunc id nisl erosin, imperdiet voluptua facilisisproin volutpat eros vel. Feugait ornare. Tation dignissim senectus, massapellentesque venenatis urna nondonec massaphasellus tristique rutrum. Urnamorbi accumsan eu. Dolore sadipscing in. Tortorvestibulum gubergren consectetuer, facilisisat nisi tellus takimata sed. Voluptua nonummy eros litora sodalessed, dapibus felissed ultricies pulvinarvestibulum a gravida tempus enimaliquam sollicitudin. Veniam maurisaenean sodales ullamcorper, augue quisaenean sit magnis adipiscing platea duimauris facilisisproin.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Tatum Joshua Tim Griffin Charlotte\",");
        json.append("  \"link\": \"http://domain.com/roger/jerry\", ");
        json.append("  \"resource_uri\": \"/api/v1/event/8/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Morbi metusdonec eros auctormauris nisised, sodales nonummy ante vehicula muspellentesque laoreet. Euismod integer lobortis montes, felissed morbi eu nobis fermentumfusce liber dictum hendrerit. Egestasmauris luptatum, sedfusce malesuada nequeetiam volutpat vel. Vel aliquyam option massa ex in, lacusut quam fusce justocras. In sit cras imperdiet sodalessed per, magna urnamorbi ridiculus autem mipellentesque.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Jeri\",");
        json.append("  \"link\": \"http://domain.com/elisabeth/tucker/ismael\",");
        json.append("  \"resource_uri\": \"/api/v1/event/9/\"");
        json.append("}, ");
        json.append("{");
        json.append("  \"text\": \"Arcu ipsumcurabitur. Aliquammauris sodalessed arcu. Nullam nostrud iriure tation cras. Arcumorbi, elitnunc velit aliquammauris mus convallis dis. Non suspendisse id ut rutrum nonumy, aptent netus vestibulumnulla no potenti arcumorbi. Purusvestibulum delenit donec luctus, curabitur suspendisse gubergren telluspraesent kasd liber volutpatut vestibulum minim. Interdumdonec etiam. Clita minulla habitant massapellentesque doming, esse facer cras facilisisproin tortorvestibulum nostrud aptent cubilia. In quammaecenas facilisisat risus urna, exerci ipsumcurabitur sagittis. Accumsan stet per maurisaenean nisised lobortis, temporsuspendisse enimsed facilisicurabitur libero esse tortor dictumstvivamus justocras. Cursus mi, lacinia odio sadipscing in dignissim. Nulla massapellentesque.\",");
        json.append("  \"image\": null, ");
        json.append("  \"title\": \"Isaac Vladimir Sinead Stacey\",");
        json.append("  \"link\": \"http://domain.com/kathleen\", ");
        json.append("  \"resource_uri\": \"/api/v1/event/10/\"");
        json.append("}");
        json.append("]");
        json.append("}");

        GsonParsingTest.JSON = json.toString();
    }

    @Test
    public void testParseJson()
    {
        // parse all
        final CombinedData data = new Gson().fromJson(GsonParsingTest.JSON, CombinedData.class);
        assertThat(data, not(nullValue()));

        // check resultant events list
        final Event[] events = data.getEvents();
        assertThat(events, not(nullValue()));
        assertThat(events.length, is(10));

        final Event event = events[0];
        assertThat(
                        event.getText(),
                        is("Interdumdonec ipsum ut inceptos varius tempus sempermorbi, clita esse ipsuminteger fusce sem consetetur montes nisi. Quis primis dictumstvivamus semper nullamauris magnainteger. Ipsuminteger lobortisetiam, mi labore at et dictumst. Conubia elitduis ad blandit nullasuspendisse. Kasd sadipscing pretium id tortorvestibulum, platea in parturient morbi luctus sodalessed urnamorbi. Proin fringilla. Odio class."));
        assertThat(event.getTitle(), is("Deirdre Zaira Liza Ross"));
        assertThat(event.getImage(), is(nullValue()));
        assertThat(event.getLink(), is("http://domain.com/darrel/megan/angelica/craig"));
        assertThat(event.getResourceUri(), is("/api/v1/event/1/"));
    }

}
