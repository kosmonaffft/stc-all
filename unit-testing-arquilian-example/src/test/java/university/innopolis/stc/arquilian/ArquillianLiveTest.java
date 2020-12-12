package university.innopolis.stc.arquilian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import university.innopolis.stc.arquillian.CapsConvertor;
import university.innopolis.stc.arquillian.CapsService;
import university.innopolis.stc.arquillian.Component;
import university.innopolis.stc.arquillian.LowerCaseConverter;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ArquillianLiveTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Component.class, CapsService.class, CapsConvertor.class, LowerCaseConverter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private Component component;

    @Inject
    private CapsService capsService;

    @Test
    public void givenMessage_WhenComponentSendMessage_ThenMessageReceived() {
        Assert.assertEquals("Message, MESSAGE", component.message(("MESSAGE")));
        component.sendMessage(System.out, "MESSAGE");
    }

    @Test
    public void givenWord_WhenUppercase_ThenLowercase() {
        assertTrue("capitalize".equals(capsService.getConvertedCaps("CAPITALIZE")));
        assertEquals("capitalize", capsService.getConvertedCaps("CAPITALIZE"));
    }
}
