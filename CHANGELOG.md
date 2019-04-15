# Changelog

All notable changes to [cljfx](https://github.com/cljfx/cljfx) will be 
documented in this file.

## [1.2.7](https://github.com/cljfx/cljfx/releases/tag/1.2.7) - 2019-04-15
### Added
- `:owner` prop for Stage and Dialog classes

## [1.2.6](https://github.com/cljfx/cljfx/releases/tag/1.2.6) - 2019-04-05
### Added
- `:stylesheets` support in components extending Parent

## [1.2.5](https://github.com/cljfx/cljfx/releases/tag/1.2.5) - 2019-03-31
### Added
- ToggleGroup support
- allow specifying `:toggle-group` in ToggleButton's descriptions declaratively ([example](examples/e25_radio_buttons.clj))

## [1.2.4](https://github.com/cljfx/cljfx/releases/tag/1.2.4) - 2019-03-30
### Added
- `:install-to` synthetic prop for Tooltips to allow declarative tooltip installation
  to non-control components ([example](examples/e26_tooltips.clj))
- `fx/unmount-renderer` function to remove watch from `*ref` that was added by
  `fx/mount-renderer` and then tear down component tree

## [1.2.3](https://github.com/cljfx/cljfx/releases/tag/1.2.3) - 2019-03-20
### Fixed
- Improved responsiveness in the presence of flood of description changes,
  see [examples/e24_concurrency.clj](examples/e24_concurrency.clj)

## [1.2.2](https://github.com/cljfx/cljfx/releases/tag/1.2.2) - 2019-03-19
### Changed
- Update JavaFX dependencies to latest stable release
- Don't warn on reflection where reflection is unavoidable

## [1.2.1](https://github.com/cljfx/cljfx/releases/tag/1.2.1) - 2019-03-17
### Added
- Support `:accelerators` prop in scene ([example](examples/e23_accelerators.clj))

## [1.2.0](https://github.com/cljfx/cljfx/releases/tag/1.2.0) - 2019-03-12
### Added
- `fx/ext-let-refs` and `fx/ext-get-ref` [extension lifecycles](https://github.com/cljfx/cljfx#included-extension-lifecycles) 
  that allow decoupling component lifecycle from component tree 

## [1.1.0](https://github.com/cljfx/cljfx/releases/tag/1.1.0) - 2019-03-03
### Added
- Treat fx-type as Lifecycle if `:fx.opt/type->lifecycle` returned 
  falsey value;
- Add some basic [extension lifecycles](https://github.com/cljfx/cljfx#extending-cljfx): 
  - `fx/ext-instance-factory` to create component instances using 
    factory function;
  - `fx/ext-on-instance-lifecycle` to observe created/advanced/deleted
    component instances.   

## [1.0.0](https://github.com/cljfx/cljfx/releases/tag/1.0.0) - 2019-02-24
Initial release
