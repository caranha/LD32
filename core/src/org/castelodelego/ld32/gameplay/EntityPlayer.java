package org.castelodelego.ld32.gameplay;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by caranha on 4/18/15.
 */
public class EntityPlayer extends Entity {

    float speed = 100;
    float jump = 1000;

    public EntityPlayer()
    {
        super();
    }

    public void init(Vector2 pos, World w)
    {
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(pos.x,pos.y);
        bodydef.fixedRotation = true;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(8,8);
        body = w.createBody(bodydef);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.filter.categoryBits = PLAYER;
        fixtureDef.filter.maskBits = FIXED|ENEMY|BULLET;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
    }


    public void render(ShapeRenderer renderer) {
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(c);
        renderer.rect(body.getPosition().x - 8, body.getPosition().y - 8, 16, 16);
    }

    public void moveLeft()
    {
        body.applyLinearImpulse(-speed,0,body.getPosition().x,body.getPosition().y,true);
    }
    public void moveRight()
    {
        body.applyLinearImpulse(speed,0,body.getPosition().x,body.getPosition().y,true);
    }
    public void jump()
    {
        body.applyLinearImpulse(0,jump,body.getPosition().x,body.getPosition().y,true);
    }


}
