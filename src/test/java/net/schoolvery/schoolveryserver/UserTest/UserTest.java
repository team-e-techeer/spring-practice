package net.schoolvery.schoolveryserver.UserTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.schoolvery.schoolveryserver.SpringTestSupport;
import net.schoolvery.schoolveryserver.domain.user.controller.UserController;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("User 단위 테스트")
public class UserTest extends SpringTestSupport {


    @DisplayName("User Create Test")
    @Test
    void 유저생성_확인() throws Exception {
        String user = mapper.writeValueAsString(new User(6,"김의빈", "Joe", 0104234, 1244,
                "성결대", "asdads","adsadsasd"));


        mockMvc.perform(
                post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(user)
                )
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                responseFields(
                                        fieldWithPath("isSuccess").description("isSuccess"),
                                        fieldWithPath("code").description("code"),
                                        fieldWithPath("message").description("message"),
                                        subsectionWithPath("result").description("result")
                                )
                        )
                );
    }

    @DisplayName("Read User")
    @Test
    public void 유저_읽기() throws Exception {
        mockMvc.perform(
                get("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                responseFields(
                                        fieldWithPath("isSuccess").description("isSuccess"),
                                        fieldWithPath("code").description("code"),
                                        fieldWithPath("message").description("message"),
                                        subsectionWithPath("result").description("result")
                                )
                        )
                );
    }

}
