"use strict";
/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
(() => {
var exports = {};
exports.id = "pages/index";
exports.ids = ["pages/index"];
exports.modules = {

/***/ "./pages/index.js":
/*!************************!*\
  !*** ./pages/index.js ***!
  \************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Home)\n/* harmony export */ });\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ \"react\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var next_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next/router */ \"next/router\");\n/* harmony import */ var next_router__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_router__WEBPACK_IMPORTED_MODULE_1__);\n// pages/index.js\n // 특정동작 실행 사용\n\n // 이동하기\n\nfunction Home() {\n  const router = (0,next_router__WEBPACK_IMPORTED_MODULE_1__.useRouter)(); // 이동하기 \n\n  (0,react__WEBPACK_IMPORTED_MODULE_0__.useEffect)(() => {\n    // 특정동작\n    router.replace('/users'); //현재경로  /users (뒤로가기 남지않음.)\n  }, [router]); // router라는 객체가 변경시  useEffect 실행\n\n  return null;\n} // npm run dev//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9wYWdlcy9pbmRleC5qcy5qcyIsIm1hcHBpbmdzIjoiOzs7Ozs7OztBQUFBO0NBRW9DOztDQUNNOztBQUUxQixTQUFTRSxJQUFULEdBQWU7RUFDM0IsTUFBTUMsTUFBTSxHQUFHRixzREFBUyxFQUF4QixDQUQyQixDQUNDOztFQUM1QkQsZ0RBQVMsQ0FBQyxNQUFJO0lBQUc7SUFDYkcsTUFBTSxDQUFDQyxPQUFQLENBQWUsUUFBZixFQURVLENBQ2lCO0VBQzlCLENBRlEsRUFFTCxDQUFDRCxNQUFELENBRkssQ0FBVCxDQUYyQixDQUlYOztFQUNoQixPQUFRLElBQVI7QUFDSCxFQUVEIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vZnJvbnQvLi9wYWdlcy9pbmRleC5qcz9iZWU3Il0sInNvdXJjZXNDb250ZW50IjpbIi8vIHBhZ2VzL2luZGV4LmpzXHJcblxyXG5pbXBvcnQgeyB1c2VFZmZlY3QgfSBmcm9tICdyZWFjdCc7ICAvLyDtirnsoJXrj5nsnpEg7Iuk7ZaJIOyCrOyaqVxyXG5pbXBvcnQgeyB1c2VSb3V0ZXIgfSBmcm9tICduZXh0L3JvdXRlcic7ICAvLyDsnbTrj5ntlZjquLBcclxuXHJcbmV4cG9ydCAgZGVmYXVsdCBmdW5jdGlvbiBIb21lKCl7XHJcbiAgICBjb25zdCByb3V0ZXIgPSB1c2VSb3V0ZXIoKTsgLy8g7J2064+Z7ZWY6riwIFxyXG4gICAgdXNlRWZmZWN0KCgpPT57ICAvLyDtirnsoJXrj5nsnpFcclxuICAgICAgICByb3V0ZXIucmVwbGFjZSgnL3VzZXJzJyk7ICAvL+2YhOyerOqyveuhnCAgL3VzZXJzICjrkqTroZzqsIDquLAg64Ko7KeA7JWK7J2MLilcclxuICAgIH0gLCBbcm91dGVyXSk7ICAvLyByb3V0ZXLrnbzripQg6rCd7LK06rCAIOuzgOqyveyLnCAgdXNlRWZmZWN0IOyLpO2WiVxyXG4gICAgcmV0dXJuICBudWxsO1xyXG59XHJcblxyXG4vLyBucG0gcnVuIGRldiJdLCJuYW1lcyI6WyJ1c2VFZmZlY3QiLCJ1c2VSb3V0ZXIiLCJIb21lIiwicm91dGVyIiwicmVwbGFjZSJdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./pages/index.js\n");

/***/ }),

/***/ "next/router":
/*!******************************!*\
  !*** external "next/router" ***!
  \******************************/
/***/ ((module) => {

module.exports = require("next/router");

/***/ }),

/***/ "react":
/*!************************!*\
  !*** external "react" ***!
  \************************/
/***/ ((module) => {

module.exports = require("react");

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../webpack-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = (__webpack_exec__("./pages/index.js"));
module.exports = __webpack_exports__;

})();