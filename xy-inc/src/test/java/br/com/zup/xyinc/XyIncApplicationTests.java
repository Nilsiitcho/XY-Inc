package br.com.zup.xyinc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.xyinc.dto.LocalUsuarioDTO;
import br.com.zup.xyinc.dto.PontoInteresseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class XyIncApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	
	@Test
	public void testeTodosPontos() throws Exception {
		mockMvc.perform(get("/todos-pontos")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testeCriarPonto() throws Exception {
		PontoInteresseDTO pontoTeste = new PontoInteresseDTO();
		pontoTeste.setX(10);
		pontoTeste.setY(10);
		pontoTeste.setId(10);
		pontoTeste.setNome("Teste");
		
		mockMvc.perform(post("/ponto-interesse").content(asJsonString(pontoTeste)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated());
	}
	
	@Test
	public void testeDeletarPonto() throws Exception {
		mockMvc.perform(delete("/ponto-interesse/{id}", 1))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testePontosProximosAoUsuario() throws Exception {
		LocalUsuarioDTO localTeste = new LocalUsuarioDTO();
		localTeste.setX(10);
		localTeste.setY(10);
		localTeste.setDistanciaMaxima(10);
		
		mockMvc.perform(post("/pontos-proximos").content(asJsonString(localTeste)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	private static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
