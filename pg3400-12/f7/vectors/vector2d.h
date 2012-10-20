#ifndef _VECTOR_H
#define _VECTOR_H

struct vector2d
{
    double x, y;
};

struct vector2d *vector2d_init();
struct vector2d *vector2d_create(double angle, double length);
double vector2d_length(struct vector2d *v);
double vector2d_angle(struct vector2d *v);
struct vector2d *vector2d_add(struct vector2d *v1, struct vector2d *v2);
struct vector2d *vector2d_sub(struct vector2d *v1, struct vector2d *v2);
double vector2d_angle_between(struct vector2d *v1, struct vector2d *v2);
struct vector2d *vector2d_projection(struct vector2d *v1, struct vector2d *v2);
double vector2d_dot(struct vector2d *v1, struct vector2d *v2);
void vector2d_destroy(struct vector2d *v);


#endif