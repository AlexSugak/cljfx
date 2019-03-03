# Changelog

All notable changes to cljfx will be documented in this file.

## [1.1.0] - 2019-03-03
### Added
- Treat fx-type as Lifecycle if `:fx.opt/type->lifecycle` returned 
  falsey value;
- Add some basic extension lifecycles: 
  - `fx/ext-instance-factory` to create component instances using 
    factory function;
  - `fx/ext-on-instance-lifecycle` to observe created/advanced/deleted
    component instances.   

## [1.0.0] - 2019-02-24
Initial release
