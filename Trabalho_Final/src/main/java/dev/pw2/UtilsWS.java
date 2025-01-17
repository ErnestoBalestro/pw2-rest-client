/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
*/
package dev.pw2;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.pw2.model.Utils;

@Path("/utils")
@Transactional
// 1 - Podemos delegar o controle de transação utilizando a anotação
// @Transactional nos métodos ou no nível da classe.
public class UtilsWS {

    @GET
    @Path("/save/utils")
    @Produces(MediaType.APPLICATION_JSON)
    public Utils save(@PathParam("numberFormat") Double numberFormat) {
        Utils utils = new Utils();
        utils.setnumberFormat (numberFormat);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        utils.persist();
        return utils;
    }


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Utils> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Utils.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Utils list(@PathParam("id") Long id) {
        // 4 - O método do Panache `findById` recupera um objeto da classe User.
        return Utils.findById(id);
    }

}