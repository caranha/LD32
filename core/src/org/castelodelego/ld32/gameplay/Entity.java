package org.castelodelego.ld32.gameplay;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by caranha on 4/18/15.
 */
public class Entity {

    public final short FIXED = 0x1;
    public final short PLAYER = 0x1<<1;
    public final short ENEMY = 0x1<<2;
    public final short BULLET = 0x1<<3;

    public enum EntityType { PLAYER, ENEMY, PEARL, WALL, TRAP, NONE};

    Body body;

    public EntityType type = EntityType.WALL;
    public Color c = Color.BLACK;

    public Entity()
    {
    }

    public void init(Vector2 pos, World w)
    {
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.StaticBody;
        bodydef.position.set(pos.x,pos.y);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(8,8);
        body = w.createBody(bodydef);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.filter.categoryBits = FIXED;
        fixtureDef.filter.maskBits = PLAYER|ENEMY|BULLET;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
    }


    public void render(ShapeRenderer renderer) {
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(c);
        renderer.rect(body.getPosition().x - 8, body.getPosition().y - 8, 16, 16);
    }
}



